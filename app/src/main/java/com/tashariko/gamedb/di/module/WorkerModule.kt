package com.tashariko.gamedb.di.module

import com.tashariko.gamedb.services.DatabaseInitialiseWorker
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WorkerModule {
    @ContributesAndroidInjector
    abstract fun bindDownloadAudioWorker(): DatabaseInitialiseWorker
}
