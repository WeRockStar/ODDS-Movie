package com.odds.movie.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.odds.movie.R
import com.odds.movie.databinding.MovieItemRowBinding

class HomeMovieAdapter(
    val movies: List<Movie>,
    val onClickMovie: (Movie) -> Unit
) :
    RecyclerView.Adapter<HomeMovieAdapter.HomeMovieViewHolder>() {

    class HomeMovieViewHolder(
        private val binding: MovieItemRowBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, onClickMovie: (Movie) -> Unit) {
            Glide.with(binding.imageMovie)
                .load(movie.image)
                .error(R.drawable.endgame)
                .transition(withCrossFade())
                .into(binding.imageMovie)

            binding.tvMovieName.text = movie.name
            binding.root.setOnClickListener { onClickMovie(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieViewHolder {
        val view = MovieItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return HomeMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeMovieViewHolder, position: Int) {
        holder.bind(movies[position], onClickMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}