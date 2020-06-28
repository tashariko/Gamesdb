package com.tashariko.gamedb.di.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Kotlin extensions for dependency injection
 *
 */

@Deprecated("Using @ViewModelInject")
inline fun <reified VM : ViewModel> FragmentActivity.injectViewModel( factory: ViewModelProvider.Factory): VM {
    return ViewModelProvider(this, factory)[VM::class.java]
}

@Deprecated("Using @ViewModelInject")
inline fun <reified VM : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): VM {
    return ViewModelProvider(this, factory)[VM::class.java]
}
