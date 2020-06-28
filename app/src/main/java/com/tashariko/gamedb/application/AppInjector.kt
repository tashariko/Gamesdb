package com.tashariko.gamedb.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.tashariko.gamedb.application.GamesDbApplication

import timber.log.Timber

object ApplicationLifecycleCallbacks {

    fun init(application: GamesDbApplication){

        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity?) {
                Timber.i("onActivityPaused")
            }

            override fun onActivityResumed(activity: Activity?) {
                Timber.i("onActivityResumed")
            }

            override fun onActivityStarted(activity: Activity?) {

            }

            override fun onActivityDestroyed(activity: Activity?) {

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

            }

            override fun onActivityStopped(activity: Activity?) {

            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                //handleFragmentLifecycle( activity )
            }

        })
    }

}