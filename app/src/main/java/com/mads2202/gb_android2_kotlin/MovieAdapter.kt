package com.mads2202.gb_android2_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mads2202.gb_android2_kotlin.databinding.SingleMovieViewFragmentBinding
import com.mads2202.gb_android2_kotlin.model.Movie

class MovieAdapter(var movieList:ArrayList<Movie>):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(){
            //todo: implement this method with databinding when we can get data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.single_movie_view_fragment,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}