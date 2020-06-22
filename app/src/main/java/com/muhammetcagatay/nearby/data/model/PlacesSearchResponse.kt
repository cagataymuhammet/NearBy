package com.muhammetcagatay.nearby.data.model

data class PlacesSearchResponse(
    val results: MutableList<SearchResult>,
    val status: String
) {
    override fun toString(): String {
        return "PlacesSearchResponse(searchResults=$results, status='$status')"
    }
}