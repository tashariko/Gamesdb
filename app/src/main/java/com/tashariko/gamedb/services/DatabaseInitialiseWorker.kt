package com.tashariko.gamedb.services

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class DatabaseInitialiseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {


    //TODO: Implement filling db
    init {

    }

    override suspend fun doWork(): Result {
        return Result.success()
    }

}