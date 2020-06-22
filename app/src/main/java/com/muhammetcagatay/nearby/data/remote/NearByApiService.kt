package com.muhammetcagatay.nearby.data.remote

import com.muhammetcagatay.nearby.data.model.PlacesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * Created by muhammetcagatay on 21,June,2020
 */
interface NearByApiService {

    @Headers("Content-Type: application/json;charset=utf-8")
    @GET("maps/api/place/textsearch/json")
    suspend  fun searchPlace(
        @Query("query") query: String?,
        @Query("key") apiKey: String?): PlacesSearchResponse

}