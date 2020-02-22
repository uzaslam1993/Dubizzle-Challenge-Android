package com.example.dubizzlechallengeandroid.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dubizzlechallengeandroid.R
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.ui.view.callback.AdSelectedListener
import kotlinx.android.synthetic.main.ad_list_item.view.*


class AdListAdapter(
    private val context: Context,
    private var adList: List<AdVO>,
    private val callback: AdSelectedListener
) : RecyclerView.Adapter<AdListAdapter.AdListViewHolder>(), Filterable {

    var filteredList: List<AdVO> = adList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdListViewHolder {
        return AdListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.ad_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    override fun onBindViewHolder(holder: AdListViewHolder, position: Int) {
        holder.bind(adList[position])
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(query: CharSequence?): FilterResults {
                adList = if (query.isNullOrEmpty()) {
                    filteredList
                } else {
                    filteredList.filter { it.name.contains(query.toString(),true) }
                }
                val filterResults = FilterResults()
                filterResults.values = adList
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                adList = filterResults?.values as ArrayList<AdVO>
                notifyDataSetChanged()
            }

        }
    }

    inner class AdListViewHolder(private val viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        fun bind(adVO: AdVO) {
            viewItem.textViewName.text = adVO.name
            viewItem.textViewPrice.text = adVO.price
            viewItem.textViewDate.text = adVO.date
            Glide.with(context).load(adVO.thumbNailUrl).into(viewItem.imageViewThumbnail)
            viewItem.setOnClickListener { callback.onAdSelected(adList[adapterPosition]) }
        }

    }
}