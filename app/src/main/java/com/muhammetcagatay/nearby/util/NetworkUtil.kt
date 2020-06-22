package com.muhammetcagatay.nearby.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by muhammetcagatay on 21,June,2020
 */

object NetworkUtil {

    public  fun isConnectedToInternet(context: Context): Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.allNetworkInfo
        for (i in info.indices)
            if (info[i].state == NetworkInfo.State.CONNECTED) {
                return true
            }
        return false
    }
}