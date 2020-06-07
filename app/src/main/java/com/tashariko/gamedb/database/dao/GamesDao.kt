package com.tashariko.gamedb.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tashariko.gamedb.database.entity.GameDetail
import kotlinx.coroutines.flow.Flow


@Dao
interface GamesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(gameList: List<GameDetail>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gameDetail: GameDetail)

    @Query("SELECT * FROM gameDetail ORDER BY popularity DESC")
    fun getGamesList(): Flow<List<GameDetail>>

    @Query("SELECT * FROM gameDetail WHERE id = :id")
    fun getGame(id: Int): Flow<GameDetail>
}
