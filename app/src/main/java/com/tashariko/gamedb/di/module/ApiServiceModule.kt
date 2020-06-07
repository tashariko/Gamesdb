package com.tashariko.gamedb.di.module

import com.tashariko.gamedb.network.apiservices.GameListApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ApiServiceModule {

    @Provides
    @Singleton
    fun provideAudioService(retrofit: Retrofit): GameListApiService {
        return retrofit.create(GameListApiService::class.java)
    }

}