package com.tashariko.gamedb.di.module

import com.tashariko.gamedb.network.apiservices.GameListApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class ApiServiceModule {

    @Provides
    @Singleton
    fun provideAudioService(retrofit: Retrofit): GameListApiService {
        return retrofit.create(GameListApiService::class.java)
    }

}