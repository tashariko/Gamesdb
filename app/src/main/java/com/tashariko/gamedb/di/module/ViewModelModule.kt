package com.tashariko.gamedb.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tashariko.gamedb.di.util.ViewModelFactory
import com.tashariko.gamedb.di.util.ViewModelKey
import com.tashariko.gamedb.ui.gamelist.GameListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GameListViewModel::class)
    abstract fun bindGameListViewModel(viewModel: GameListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
