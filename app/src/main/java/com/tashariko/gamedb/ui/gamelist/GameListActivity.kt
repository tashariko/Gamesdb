package com.tashariko.gamedb.ui.gamelist

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.tashariko.gamedb.R
import com.tashariko.gamedb.application.base.BasActivity
import com.tashariko.gamedb.database.entity.GameDetail
import com.tashariko.gamedb.di.util.injectViewModel
import javax.inject.Inject
import com.tashariko.gamedb.network.result.Result
import timber.log.Timber

class GameListActivity : BasActivity(){

    @BindView(R.id.progressBarView)
    lateinit var progressView:ProgressBar

    @BindView(R.id.recyclerView)
    lateinit var recyclerView:RecyclerView

    @BindView(R.id.swipeRefreshView)
    lateinit var swipeRefreshView:SwipeRefreshLayout

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: GameListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamelist)
        ButterKnife.bind(this)

        viewModel = injectViewModel(viewModelFactory)
        bindUI()

        swipeRefreshView.setOnRefreshListener {
            viewModel.retry()
        }

        viewModel.retry()

    }

    private fun bindUI() {
        viewModel.gameListLiveData.observe(this, Observer { result ->
            swipeRefreshView.isRefreshing = false
            when (result.status) {
                Result.Status.SUCCESS -> {

                    result.data?.let {

                        Timber.i("DATA__SUCCESS__${result.data}")
                        progressView.visibility = View.GONE
                        swipeRefreshView.visibility = View.VISIBLE

                        setupAdapter(it)
                    }
                }
                Result.Status.LOADING -> {
                    Timber.i("DATA__Loading__${result.data }")
                    progressView.visibility = View.VISIBLE
                    swipeRefreshView.visibility = View.GONE
                }
                Result.Status.ERROR -> {
                    Timber.i("DATA__Error__${result.data }")
                    progressView.visibility = View.GONE
                    swipeRefreshView.visibility = View.GONE
                    result.data?.let {
                        swipeRefreshView.visibility = View.VISIBLE
                        setupAdapter(it)
                    }

                    Toast.makeText(this, result.errorType?.message,Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupAdapter(list: List<GameDetail>) {
        val gameAdapter = GameListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = gameAdapter
        gameAdapter.submitList(list)

        gameAdapter.notifyDataSetChanged()

    }

}