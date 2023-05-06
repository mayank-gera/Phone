package com.example.phone.viewcontrollers.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.phone.R
import com.example.phone.model.Result


class ListingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView
    private val descView: TextView
    private val movieImageView: ImageView

    init {
        titleTextView = itemView.findViewById(R.id.movieName)
        descView = itemView.findViewById(R.id.movieDesc)
        movieImageView = itemView.findViewById(R.id.movieImage)
    }

    fun bindViewHolder(result: Result, position: Int) {
        titleTextView.text = result.title
        descView.text = result.overview

        if (!result.posterPath.isNullOrEmpty()) {
            val imageUrl =
                "https://image.tmdb.org/t/p/w500${result.posterPath}"
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))
            Glide.with(itemView)
                .load(imageUrl)
                .apply(requestOptions)
                .into(movieImageView)
        }


    }

}