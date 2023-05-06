package com.example.phone.viewcontrollers.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R
import com.example.phone.viewcontrollers.ListingViewModel
import com.example.phone.viewcontrollers.adapter.ListingAdapter

class ListingFragment : Fragment() {

    companion object {
        fun newInstance() = ListingFragment()
    }

    private var recyclerView : RecyclerView? = null
    private lateinit var viewModel: ListingViewModel
    private var listingAdapter : ListingAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        setUpAdapter()

    }

    private fun initView(view: View) {
//        Could use viewbinding but due to shortage of time going with this.
        recyclerView = view.findViewById(R.id.recyclerList)
    }

    private fun setUpAdapter() {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            listingAdapter = ListingAdapter()
            adapter = listingAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ListingViewModel::class.java]
        setupObserver()
        viewModel.getListOfMovies()

    }

    private fun setupObserver() {
        viewModel.movies.observe(viewLifecycleOwner){
            listingAdapter?.submitList(it)
        }

    }

}