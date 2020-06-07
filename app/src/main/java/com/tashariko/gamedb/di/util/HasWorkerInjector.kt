package com.tashariko.gamedb.di.util

import androidx.work.CoroutineWorker
import dagger.android.AndroidInjector


interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<CoroutineWorker>
}
