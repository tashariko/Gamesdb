
package com.tashariko.gamedb.network

import androidx.annotation.MainThread
import com.tashariko.gamedb.network.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

/**
 * A repository which provides resource from local database as well as remote end point.
 *
 * [RESULT] represents the type for database.
 * [REQUEST] represents the type for network.
 */
@ExperimentalCoroutinesApi
abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun flowData(databaseQuery: () -> Flow<RESULT>,
                 networkCall: suspend () -> Result<REQUEST>,
                 saveCallResult: suspend (REQUEST) -> Unit,
                parseNetworkResponse: (REQUEST) -> Result<RESULT>): Flow<Result<RESULT>> = flow<Result<RESULT>> {

        // emit(someValue) is similar to myData.value = someValue whereas
        // emitSource(someLiveValue) is similar to myData = someLiveValue.
        emit(Result.loading<RESULT>())
        val source = databaseQuery.invoke().map { Result.success(it) }
        emit(Result.loading<RESULT>(source.first().data))

        //run it(remoteSource.fetchData()) here on running invoke method
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Result.Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)
            emit(parseNetworkResponse(responseStatus.data))
        } else if (responseStatus.status == Result.Status.ERROR) {
            emit(Result.error<RESULT>(responseStatus.errorType,source.first().data))
        }


    }.flowOn(Dispatchers.IO)

    //Todo Add extra implementations for usage like no database, no save

    /**
     * return false when we dont want to save database transactions for this response.
     */
    protected open fun shouldfetchDataFromDbBeforeNetwork(): Boolean {
        return true
    }


    /**
     * return false when we dont want to save database transactions for this response.
     */
    protected open fun shouldStoreDataInDbAfterNetwork(): Boolean {
        return true
    }
}