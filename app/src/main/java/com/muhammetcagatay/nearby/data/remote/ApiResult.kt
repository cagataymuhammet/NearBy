package com.boomset.attendeeapp.data.networking

import com.muhammetcagatay.nearby.util.Constants
import com.muhammetcagatay.nearby.util.Constants.API_STATUS.*

/**
 * Created by muhammetcagatay on 02,March,2020
 */

data class ApiResult<out T>(val status: Constants.API_STATUS, val data: T?, val message: String?) {
    companion object {

        fun <T> loading(data: T?): ApiResult<T> = ApiResult(status = LOADING, data = data, message = null)

        fun <T> success(data: T): ApiResult<T> = ApiResult(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ApiResult<T> = ApiResult(status = ERROR, data = data, message = message)

    }
}