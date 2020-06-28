package com.tashariko.gamedb.services

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import timber.log.Timber

class DatabaseInitialiseWorker @WorkerInject constructor(@Assisted context: Context, @Assisted workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {

        return Result.success()
    }

}