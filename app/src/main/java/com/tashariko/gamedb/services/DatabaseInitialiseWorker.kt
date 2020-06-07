package com.tashariko.gamedb.services

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.tashariko.gamedb.di.util.AndroidWorkerInjection

class DatabaseInitialiseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    init {
        AndroidWorkerInjection.inject(this)
    }

    override suspend fun doWork(): Result {
        return Result.success()
    }

}