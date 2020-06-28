package com.tashariko.gamedb.ui.gamelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.tashariko.gamedb.database.dao.GamesDao
import com.tashariko.gamedb.database.entity.GameDetail
import com.tashariko.gamedb.network.NetworkBoundRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import com.tashariko.gamedb.network.result.Result
import dagger.hilt.android.EntryPointAccessors

class GameListRemoteRepository @Inject constructor(private val gamesDao: GamesDao, private val gameListRemoteDataSource: GameListRemoteDataSource) {

    fun getData() = object: NetworkBoundRepository<List<GameDetail>, ArrayList<GameDetail>>(){
        override fun shouldStoreDataInDbAfterNetwork(): Boolean {
            return true
        }

        override fun shouldfetchDataFromDbBeforeNetwork(): Boolean {
            return true
        }
    }.flowData(
        databaseQuery = { getDatabaseData() },
        networkCall = { initiateNetworkCall() },
        saveCallResult = { saveResult(it) },
        parseNetworkResponse = { Result.success(it) }
    )

    private fun getDatabaseData(): Flow<List<GameDetail>> {

        return gamesDao.getGamesList()
    }

    private suspend fun initiateNetworkCall(): Result<ArrayList<GameDetail>> {
        return gameListRemoteDataSource.fetchGameList()
    }

    private suspend fun saveResult(result: ArrayList<GameDetail>) {
        return gamesDao.insertAll(result)
    }

}