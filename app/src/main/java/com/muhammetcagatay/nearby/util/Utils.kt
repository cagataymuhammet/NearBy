package com.muhammetcagatay.nearby.util

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.google.gson.Gson
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.ui.map.MapActivity
import kotlin.reflect.KClass

/**
 * Created by muhammetcagatay on 21,June,2020
 */

object Utils {

    fun buildProgressDilalog(context: Context): ProgressDialog {
        val progressDialog: ProgressDialog = ProgressDialog(context,R.style.TransparentProgressDialog)
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog.setContentView(R.layout.dialog_progress)
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }

    fun getErrorMessage(context: Context):String {
        return context.getString(R.string.app_name)
    }

    fun getSearchResultByString(objectStr: String): SearchResult {
        return Gson().fromJson(objectStr,  SearchResult::class.java)
    }

    fun getStringBySearchResult(item: SearchResult): String {
        return Gson().toJson(item)
    }

}