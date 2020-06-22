package com.muhammetcagatay.nearby.data.repository

import android.content.Context
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.PlacesSearchResponse
import com.muhammetcagatay.nearby.data.remote.NearByApiService

/**
 * Created by muhammetcagatay on 21,June,2020
 */

class NearByRetrofitRepositoryImpl(private val nearByApiService: NearByApiService) : NearByRepository {

    override suspend fun searchPlace(context: Context, query: String):PlacesSearchResponse {
        return  nearByApiService.searchPlace(query,context.getString(R.string.google_maps_key))
    }
}
