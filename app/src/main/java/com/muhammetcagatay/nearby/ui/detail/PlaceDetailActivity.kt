package com.muhammetcagatay.nearby.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.ui.base.BindingBaseActivity
import com.muhammetcagatay.nearby.util.Constants
import com.muhammetcagatay.nearby.util.Utils

class PlaceDetailActivity : BindingBaseActivity() {

    var txtName:TextView?=null
    var txtAdress:TextView?=null
    var imgPlace :ImageView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        if(intent.getStringExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT)!=null) {
            searchResult = Utils.getSearchResultByString(intent.getStringExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT))
            init()
        }
    }


    fun init()
    {
        txtName =findViewById(R.id.txtName)
        txtAdress =findViewById(R.id.txtAdress)
        imgPlace =findViewById(R.id.imgPlace)


        txtName!!.text =searchResult!!.name
        txtAdress!!.text =searchResult!!.formatted_address

        if(!searchResult!!.photos.isNullOrEmpty())
        {
            Glide.with(applicationContext).load(Utils.getPhotoUrlByReferance(searchResult!!.photos.get(0).photo_reference,applicationContext)).centerCrop().into(imgPlace!!)
        }
    }


}
