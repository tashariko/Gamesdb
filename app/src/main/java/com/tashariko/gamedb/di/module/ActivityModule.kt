package com.tashariko.gamedb.di.module

import com.tashariko.gamedb.ui.gamelist.GameListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeGamelistActivity(): GameListActivity
}
