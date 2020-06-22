package com.muhammetcagatay.nearby.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.databinding.ActivitySplashBinding
import com.muhammetcagatay.nearby.ui.base.BindingBaseActivity
import com.muhammetcagatay.nearby.ui.search.SearchActivity

class SplashActivity : BindingBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() { startSearchActiviy() }
        }.start()
    }

    fun startSearchActiviy() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
        finish()
    }

}
