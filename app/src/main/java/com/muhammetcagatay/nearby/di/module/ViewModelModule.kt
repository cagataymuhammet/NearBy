
package com.muhammetcagatay.nearby.di.module
import com.muhammetcagatay.nearby.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
  viewModel { SearchViewModel(get()) }
}
