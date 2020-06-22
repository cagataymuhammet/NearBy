package com.muhammetcagatay.nearby.data.model

data class SearchResult(
    val business_status: String,
    val formatted_address: String,
    val geometry: Geometry,
    val icon: String,
    val id: String,
    val name: String,
    val opening_hours: OpeningHours,
    val photos: MutableList<Photo>,
    val place_id: String,
    val rating: Double,
    val reference: String,
    val types: MutableList<String>,
    val user_ratings_total: Int
)