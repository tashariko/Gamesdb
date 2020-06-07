package com.tashariko.gamedb.application.base

import com.tashariko.gamedb.network.result.ErrorType
import com.tashariko.gamedb.network.result.Result
import retrofit2.Response
import timber.log.Timber

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            Timber.e("${response.code()}")
            return Result.error( errorType = ErrorType(ErrorType.Type.Backend, "Network call has failed for a following reason:  ${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            Timber.e(e)
            return Result.error( errorType = ErrorType(ErrorType.Type.Generic, "Network call has failed for a following reason: ${e.message}"))
        }
    }

}

