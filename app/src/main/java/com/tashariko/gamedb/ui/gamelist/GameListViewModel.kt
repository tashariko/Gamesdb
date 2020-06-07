package com.tashariko.gamedb.ui.gamelist

import androidx.lifecycle.*
import com.tashariko.gamedb.database.entity.GameDetail
import com.tashariko.gamedb.network.result.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameListViewModel @Inject constructor(val repository: GameListRemoteRepository) : ViewModel() {

    private val _tempGameListLiveData = MutableLiveData<Result<List<GameDetail>>>()

    val gameListLiveData: LiveData<Result<List<GameDetail>>>
        get() = _tempGameListLiveData

    fun retry() {
        viewModelScope.launch {
            repository.getData().collect {
                _tempGameListLiveData.value = it
            }
        }
    }

}
