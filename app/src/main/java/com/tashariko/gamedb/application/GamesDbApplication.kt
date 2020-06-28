package com.tashariko.gamedb.application

import androidx.hilt.work.HiltWorkerFactory
import androidx.multidex.MultiDexApplication
import androidx.startup.AppInitializer
import androidx.work.Configuration
import com.tashariko.gamedb.services.initializer.StethoInitializer
import com.tashariko.gamedb.services.initializer.TimberInitializer
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject


@HiltAndroidApp
class GamesDbApplication: MultiDexApplication(), Configuration.Provider  {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()

        ApplicationLifecycleCallbacks.init(this)

        /**
         * Not doing here as done in manifest
         */
//        AppInitializer.getInstance(this).initializeComponent(TimberInitializer::class.java)
//        AppInitializer.getInstance(this).initializeComponent(StethoInitializer::class.java)

        //Will happen after Initializer intialiases itself
        Timber.i("Application Initialized")

    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

}