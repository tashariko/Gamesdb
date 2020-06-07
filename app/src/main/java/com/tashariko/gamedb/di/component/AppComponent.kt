package com.tashariko.gamedb.di.component

import android.app.Application
import com.tashariko.gamedb.application.GamesDbApplication
import com.tashariko.gamedb.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DbModule::class,
        ActivityModule::class,
        ApiServiceModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: GamesDbApplication)

}