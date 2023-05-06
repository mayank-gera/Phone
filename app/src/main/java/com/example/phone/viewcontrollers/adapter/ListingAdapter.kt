package com.example.phone.viewcontrollers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R
import com.example.phone.model.Result
import com.example.phone.viewcontrollers.viewholders.ListingItemViewHolder

class ListingAdapter(private val callback: ClickedItemCallback) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = listOf<Result>()

    fun submitList(listOfData: List<Result>) {
        list = listOfData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ListingItemViewHolder(view).apply {
            itemView.setOnClickListener {
                if (adapterPosition != -1) {
                    callback.onItemClicked(list[adapterPosition])
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ListingItemViewHolder)?.bindViewHolder(list[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_listing_view
    }

    interface ClickedItemCallback {
        fun onItemClicked(res: Result)
    }
}