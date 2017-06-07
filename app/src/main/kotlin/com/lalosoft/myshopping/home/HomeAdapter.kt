package com.lalosoft.myshopping.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.lalosoft.myshopping.R
import com.lalosoft.myshopping.data.inflate
import com.lalosoft.myshopping.data.load
import com.lalosoft.myshopping.domain.Item
import kotlinx.android.synthetic.main.view_list_item.view.*

class HomeAdapter(val list: List<Item>) : RecyclerView.Adapter<HomeAdapter.HomeItemViewHolder>() {

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        return HomeItemViewHolder(parent.inflate(R.layout.view_list_item))
    }

    override fun getItemCount() = list.size

    class HomeItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Item) = with(itemView) {
            item_text.text = item.name
            item_image.load(item.url)
        }
    }

}
