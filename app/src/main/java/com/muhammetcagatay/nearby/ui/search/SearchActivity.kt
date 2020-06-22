package com.muhammetcagatay.nearby.ui.search

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammetcagatay.nearby.R
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.ui.base.BindingBaseActivity
import com.muhammetcagatay.nearby.ui.map.MapActivity
import com.muhammetcagatay.nearby.util.Constants
import com.muhammetcagatay.nearby.util.Constants.API_STATUS.*
import com.muhammetcagatay.nearby.util.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BindingBaseActivity() {


    private val viewModel: SearchViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter :SearchAdapter
    private lateinit var searchView : SearchView
    var searchList:MutableList<SearchResult> ?=null

    //private val binding: ActivitySearchBinding by binding(R.layout.activity_search)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        init()
    }

    @SuppressLint("WrongConstant")
    fun init()
    {
       // viewModel=  ViewModelProviders.of(this).get(SearchViewModel::class.java)

        searchView = findViewById<SearchView>(R.id.searchView)
        recyclerView = findViewById<RecyclerView>(R.id.rvSearch)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        recyclerViewAdapter = SearchAdapter(searchList, object : SearchAdapter.OnItemClickListener {
            override fun onClick(item: SearchResult) {

                val intent=Intent(applicationContext,MapActivity::class.java)
                intent.putExtra(Constants.MOVE_BUNDLE_ITEM_SEARCH_RESULT, Utils.getStringBySearchResult(item))
                startActivity(intent)
            }
        })


        recyclerView.adapter = recyclerViewAdapter
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                makeSearch(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun makeSearch(query:String) {
        hideLoading()
        viewModel.searchPlace(applicationContext,query).observe(this, Observer {
            it?.let { apiResult ->

                Log.e("CAGATAY_API_R",apiResult.toString())
                when (apiResult.status)
                {
                    SUCCESS -> {
                         recyclerView.visibility = View.VISIBLE
                         hideLoading()
                         apiResult.data?.let { resultData -> retrieveList(resultData.results) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        hideLoading()
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                         showLoading(this)
                         recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(result: MutableList<SearchResult>) {
        recyclerViewAdapter.apply {
            setList(result)
            notifyDataSetChanged()
        }
    }
}
