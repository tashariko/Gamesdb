package com.tashariko.gamedb.di.injectable

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.tashariko.gamedb.application.GamesDbApplication
import com.tashariko.gamedb.di.component.DaggerAppComponent

import timber.log.Timber

object AppInjector {

    fun init(application: GamesDbApplication){
        DaggerAppComponent.builder().application(application).build().inject(application)

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


    private fun handleFragmentLifecycle(activity: Activity) {
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                            Timber.i(f.javaClass.name)
                        }
                    }, true)
        }
    }

}