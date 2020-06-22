package com.muhammetcagatay.nearby.ui.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult

/**
 * Created by muhammetcagatay on 21,June,2020
 */
class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val txtPlaceName = itemView.findViewById<TextView>(R.id.txtPlaceName)
    val txtPlaceAdress = itemView.findViewById<TextView>(R.id.txtPlaceAdress)
    val imgPlaceIcon = itemView.findViewById<ImageView>(R.id.imgTypeIcon)

    fun onClick(resultItem: SearchResult, listener: SearchAdapter.OnItemClickListener)
    {
        itemView.setOnClickListener {
            listener.onClick(resultItem)
        }
    }
}