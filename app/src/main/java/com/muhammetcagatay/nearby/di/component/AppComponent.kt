package com.muhammetcagatay.nearby.di.component

import com.muhammetcagatay.nearby.di.module.networkModule
import com.muhammetcagatay.nearby.di.module.repositoryModule
import com.muhammetcagatay.nearby.di.module.viewModelModule


val appComponent = listOf(
    viewModelModule,
    repositoryModule,
    networkModule
)
