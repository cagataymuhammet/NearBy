package com.muhammetcagatay.nearby.data.repository

import android.content.Context
import com.muhammetcagatay.nearby.data.model.PlacesSearchResponse
import com.muhammetcagatay.nearby.data.remote.NearByApiService

/**
 * Created by muhammetcagatay on 21,June,2020
 */
interface NearByRepository {

    suspend fun searchPlace(context: Context,query:String): PlacesSearchResponse
}

