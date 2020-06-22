package com.muhammetcagatay.nearby.ui.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.util.Utils

/**
 * Created by muhammetcagatay on 21,June,2020
 */

abstract  class BindingBaseActivity  :AppCompatActivity() {

    var searchResult: SearchResult?=null

    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> = lazy {
        DataBindingUtil.setContentView<T>(this, resId) }

    var progressDialog: ProgressDialog? = null

    fun showLoading(context: Context) {
        progressDialog = Utils.buildProgressDilalog(context)
        progressDialog!!.show()
    }

    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }
        }
    }
}