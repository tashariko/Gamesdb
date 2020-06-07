package com.tashariko.gamedb.application

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDexApplication
import androidx.work.CoroutineWorker
import com.facebook.stetho.Stetho
import com.tashariko.gamedb.BuildConfig
import com.tashariko.gamedb.di.injectable.AppInjector
import com.tashariko.gamedb.di.util.HasWorkerInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject


class GamesDbApplication: MultiDexApplication(), HasActivityInjector, HasWorkerInjector  {

    @Inject
    lateinit var workerDispatchingAndroidInjector: DispatchingAndroidInjector<CoroutineWorker>

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        AppInjector.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun workerInjector(): AndroidInjector<CoroutineWorker> = workerDispatchingAndroidInjector
}