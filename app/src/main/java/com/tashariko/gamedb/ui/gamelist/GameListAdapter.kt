package com.tashariko.gamedb.ui.gamelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import coil.api.load
import com.tashariko.gamedb.R
import com.tashariko.gamedb.database.entity.GameDetail

class GameListAdapter: ListAdapter<GameDetail, GameListAdapter.GameListViewHolder>(GameDiffCalback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_games,parent,false)
        return GameListViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        holder.configure(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class GameListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            ButterKnife.bind(this,itemView)
        }

        @BindView(R.id.imageView)
        lateinit var imageView: ImageView

        @BindView(R.id.titleView)
        lateinit var titleView:TextView

        @BindView(R.id.subTitleView)
        lateinit var subTitleView:TextView

        fun configure(item: GameDetail) {
            item.url.let {
                imageView.load(it)
            }

            titleView.text = item.name
            item.summary.let {
                subTitleView.text = it
            }
        }

    }
}