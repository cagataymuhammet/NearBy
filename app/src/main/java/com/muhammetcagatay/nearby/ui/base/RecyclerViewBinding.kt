/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.disneymotions.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.muhammetcagatay.nearby.data.model.SearchResult
import com.muhammetcagatay.nearby.ui.search.SearchAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, searchAdapter: SearchAdapter) {
  view.adapter = searchAdapter
}

@BindingAdapter("adapterSearch")
fun bindAdapterPosterList(view: RecyclerView, searchResult: MutableList<SearchResult>)
{
  (view.adapter as? SearchAdapter)?.setList(searchResult)
}
