package com.muhammetcagatay.nearby.util

import com.muhammetcagatay.nearby.BuildConfig

/**
 * Created by muhammetcagatay on 21,June,2020
 */
object Constants {

    val BASE_URL=BuildConfig.BASE_URL

    const val MOVE_BUNDLE_ITEM_SEARCH_RESULT = "move_bundle_item_search_result"

    enum class API_STATUS {
        SUCCESS,
        ERROR,
        LOADING
    }
}