package com.muhammetcagatay.nearby.ui.map

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.ui.base.BindingBaseActivity
import com.muhammetcagatay.nearby.ui.detail.PlaceDetailActivity
import com.muhammetcagatay.nearby.util.Constants
import com.muhammetcagatay.nearby.util.Utils


class MapActivity : BindingBaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        if(intent.getStringExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT)!=null) {
            searchResult =Utils.getSearchResultByString(intent.getStringExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT))
        }
    }


    fun openDetail()
    {
        var intent= Intent(applicationContext,PlaceDetailActivity::class.java)
        intent.putExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT, Utils.getStringBySearchResult(searchResult!!))
        startActivity(intent)
    }

    override fun onMapReady(googleMap: GoogleMap)
    {
        mMap = googleMap

        val latLng = LatLng(  searchResult!!.geometry.location.lat, searchResult!!.geometry.location.lng)

        val marker=  mMap.addMarker(MarkerOptions().position(latLng).title(searchResult!!.name))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    latLng.latitude,
                    latLng.longitude
                ), 20f
            )
        )

        mMap.setInfoWindowAdapter(object :GoogleMap.InfoWindowAdapter{

            override fun getInfoContents(markerItem: Marker?): View {
                // Getting view from the layout file infowindowlayout.xml
                var roortView=layoutInflater.inflate(R.layout.item_map_marker_window, null)
                var txtName=roortView.findViewById(R.id.txtPlaceName) as TextView
                txtName.text =searchResult!!.name

                var txtAdress=roortView.findViewById(R.id.txtPlaceAdress) as TextView
                txtAdress.text =searchResult!!.formatted_address

                return roortView;
            }

            override fun getInfoWindow(markerItem: Marker?): View? {
                return null
            }
        })

        mMap.setOnInfoWindowClickListener(
            OnInfoWindowClickListener {
                openDetail()
            }
        )

        marker.showInfoWindow()
    }
}
