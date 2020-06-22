package com.muhammetcagatay.nearby

import android.app.Application
import com.muhammetcagatay.nearby.di.component.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NearByApplicaton : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoinDI()
    }

    private fun initKoinDI() = startKoin {
        androidContext(this@NearByApplicaton)
        modules(appComponent)
    }

}