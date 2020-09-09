package com.tashariko.gamedb.ui.gamelist

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.tashariko.gamedb.database.entity.GameDetail
import com.tashariko.gamedb.network.result.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GameListViewModel @ViewModelInject constructor(private val repository: GameListRemoteRepository) : ViewModel() {

    private val _tempGameListLiveData = MutableLiveData<Result<List<GameDetail>>>()

    var runnable = Runnable {
        try {
            Thread.sleep(10000)

            Log.i("__TAG", "Done")
        }catch (e:Exception){
            Log.i("__TAG", "Interrupted")
        }
    }

    private var thread = Thread(runnable)

    init {

        thread.start()
    }

    val gameListLiveData: LiveData<Result<List<GameDetail>>>
        get() = _tempGameListLiveData

    fun retry() {
        viewModelScope.launch {
            repository.getData().collect {
                Log.i("__TAG", "Got Data")
                _tempGameListLiveData.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        thread.interrupt()
    }


}
