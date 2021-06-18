package com.mads2202.gb_android2_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mads2202.gb_android2_kotlin.model.ActorsLab

class MovieListFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.list_fragment,container,false)
        val  recyclerView=view.findViewById<RecyclerView>(R.id.movie_recycler_view)
        recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        recyclerView.adapter=MovieAdapter()

    }
}