package com.tashariko.gamedb.ui.gamelist

import com.tashariko.gamedb.application.AppConstants.gameListItemsFields
import com.tashariko.gamedb.application.base.BaseDataSource
import com.tashariko.gamedb.network.apiservices.GameListApiService
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject


class GameListRemoteDataSource @Inject constructor(val service: GameListApiService) : BaseDataSource()  {

    suspend fun fetchGameList() = getResult {
        service.getGameList(gameListItemsFields.toRequestBody("text/plain".toMediaTypeOrNull()))
    }

}