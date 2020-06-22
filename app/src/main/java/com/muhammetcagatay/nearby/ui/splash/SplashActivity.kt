package com.muhammetcagatay.nearby.ui.splash

import android.content.Intent
import android.os.Bundle
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.databinding.ActivitySplashBinding
import com.muhammetcagatay.nearby.ui.base.BindingBaseActivity
import com.muhammetcagatay.nearby.ui.search.SearchActivity

class SplashActivity : BindingBaseActivity() {

    private val binding: ActivitySplashBinding by binding(R.layout.activity_splash)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,  SearchActivity::class.java))
        finish()
    }

}
