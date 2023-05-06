package com.example.phone.viewcontrollers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.phone.R
import com.example.phone.model.Result

class ListingDetailFragment: Fragment() {
    var result : Result? = null

    private var releaseDateView: TextView? = null
    private var ratingView: TextView? = null
    private var popularityView: TextView? = null
    private var descView: TextView? = null
    private var movieImageView: ImageView? = null
    companion object {
        fun newInstance() = ListingDetailFragment()

        fun getInstanceWithData(res: Result) = ListingDetailFragment().apply {
//            Ideally this should be passed in bundle as parcelable.
            result = res
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmet_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initData(result)
    }

    private fun initData(result: Result?) {
        result?.let {
            releaseDateView?.text = it.releaseDate
            popularityView?.text = it.popularity?.toString()
            ratingView?.text = it.voteAverage?.toString()
            descView?.text= it.overview
            if (!it.posterPath.isNullOrEmpty()) {
                val imageUrl =
                    "https://image.tmdb.org/t/p/w500${result.posterPath}"
                var requestOptions = RequestOptions()
                requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))
                movieImageView?.let {imageView ->
                    Glide.with(imageView.context)
                        .load(imageUrl)
                        .apply(requestOptions)
                        .into(imageView)
                }
            }
        }
    }

    private fun initView(itemView: View) {
        releaseDateView = itemView.findViewById(R.id.releaseDate)
        popularityView = itemView.findViewById(R.id.popularity)
        ratingView = itemView.findViewById(R.id.rating)
        descView = itemView.findViewById(R.id.overview)
        movieImageView = itemView.findViewById(R.id.main_image)
    }
}