package com.tashariko.gamedb.network.apiservices

import com.tashariko.gamedb.database.entity.GameDetail
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface GameListApiService {

    /**
     * body ->
     * fields cover,created_at, first_release_date,name,parent_game,popularity,pulse_count,rating,rating_count,slug,standalone_expansions,status,storyline,summary,time_to_beat,total_rating,total_rating_count,updated_at,url,version_parent,version_title; limit 100; sort popularity desc;
     */
    @POST("/games/")
    suspend fun getGameList(@Body body: RequestBody): Response<ArrayList<GameDetail>>
}