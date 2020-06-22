package com.muhammetcagatay.nearby.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult

/**
 * Created by muhammetcagatay on 10,March,2020
 */
class SearchAdapter(var context: Context,var searchSearchResultList: MutableList<SearchResult>?, val listener: OnItemClickListener): RecyclerView.Adapter<SearchViewHolder>() {

    fun setList(list: MutableList<SearchResult>) {
        searchSearchResultList=list
    }

    interface OnItemClickListener {
        fun onClick(item: SearchResult)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.txtPlaceName?.text = searchSearchResultList!!.get(position).name
         holder.txtPlaceAdress?.text =searchSearchResultList!!.get(position).formatted_address

        if(searchSearchResultList!!.get(position).icon!="")
        {
            holder.imgPlaceIcon.setImageBitmap(null)
            Glide.with(context).load(searchSearchResultList!!.get(position).icon).override(40,40).into(holder.imgPlaceIcon)
            //holder.imgPlaceIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
        }


        holder.onClick(searchSearchResultList!!.get(position),listener)
    }

    override fun onCreateViewHolder(parentView: ViewGroup, position: Int): SearchViewHolder {
        val view = LayoutInflater.from(parentView.context).inflate(R.layout.cardview_search_item, parentView, false)
        return SearchViewHolder(view);
    }

    override fun getItemCount(): Int {
        if(!searchSearchResultList.isNullOrEmpty()) {
            return searchSearchResultList!!.size
        }
        return 0
    }
}