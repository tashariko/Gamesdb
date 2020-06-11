package com.tashariko.gamedb.application

import android.app.Activity
import androidx.multidex.MultiDexApplication
import androidx.work.CoroutineWorker
import com.facebook.stetho.Stetho
import com.tashariko.gamedb.BuildConfig
import com.tashariko.gamedb.di.injectable.AppInjector
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject


@HiltAndroidApp
class GamesDbApplication: MultiDexApplication()  {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        AppInjector.init(this)
    }

}