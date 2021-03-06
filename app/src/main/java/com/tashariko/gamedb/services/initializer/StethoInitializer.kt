package com.tashariko.gamedb.services.initializer

import android.content.Context
import androidx.startup.Initializer
import com.facebook.stetho.Stetho
import com.tashariko.gamedb.BuildConfig
import timber.log.Timber

class StethoInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(context)

        Timber.i("Stetho Initialized")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(TimberInitializer::class.java)
    }

}