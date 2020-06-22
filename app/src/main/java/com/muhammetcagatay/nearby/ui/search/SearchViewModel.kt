package com.muhammetcagatay.nearby.ui.search

import android.content.Context
import androidx.lifecycle.*
import com.boomset.attendeeapp.data.networking.ApiResult
import com.muhammetcagatay.nearby.data.repository.NearByRetrofitRepositoryImpl
import com.muhammetcagatay.nearby.util.Utils
import kotlinx.coroutines.Dispatchers

/**
 * Created by muhammetcagatay on 21,June,2020
 */


class SearchViewModel(private  var nearByRepository :NearByRetrofitRepositoryImpl) : ViewModel() {

    fun searchPlace(context: Context, query: String) = liveData(Dispatchers.IO) {
        emit(ApiResult.loading(data = null))
        try {
            emit(ApiResult.success(data = nearByRepository.searchPlace(context,query)))
        } catch (exception: Exception) {
            emit(ApiResult.error(data = null, message = exception.message ?: Utils.getErrorMessage(context)))
        }
    }
}