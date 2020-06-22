package com.muhammetcagatay.nearby.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.ui.base.BindingBaseActivity
import com.muhammetcagatay.nearby.util.Constants
import com.muhammetcagatay.nearby.util.Utils

class PlaceDetailActivity : BindingBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        if(intent.getStringExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT)!=null) {
            searchResult = Utils.getSearchResultByString(intent.getStringExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT))
        }
    }


}
