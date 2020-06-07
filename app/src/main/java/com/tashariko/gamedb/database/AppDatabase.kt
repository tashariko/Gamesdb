package com.tashariko.gamedb.database

import android.provider.MediaStore.Audio
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tashariko.gamedb.database.dao.GamesDao
import com.tashariko.gamedb.database.dao.UserDao
import com.tashariko.gamedb.database.entity.GameDetail
import com.tashariko.gamedb.database.entity.User


@Database(
    entities = [User::class, GameDetail::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun gamesDao(): GamesDao
}