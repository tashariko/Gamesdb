package com.tashariko.gamedb.network

import android.content.Context
import android.os.Build
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor(val mContext: Context, val accessToken: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("user-key", accessToken)
            .addHeader("os", Build.VERSION.SDK_INT.toString())
            .addHeader("requestUuid", UUID.randomUUID().toString()).build()
        return chain.proceed(request)
    }
}