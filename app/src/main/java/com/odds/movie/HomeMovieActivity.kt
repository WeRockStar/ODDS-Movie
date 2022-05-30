package com.odds.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.odds.movie.databinding.ActivityHomeMovieBinding
import com.odds.movie.movie.HomeMovieAdapter
import com.odds.movie.movie.Movie
import com.odds.movie.movie.MovieActivity

class HomeMovieActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeMovieBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val movies = createMovie()
        val adapter = HomeMovieAdapter(movies) { movie ->
            val intent = Intent(this, MovieActivity::class.java)
            intent.putExtra(MovieActivity.EXTRA_MOVIE, movie)
            startActivity(intent)
        }
        val layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

    }

    private fun createMovie() = listOf(
        Movie(1, "Avenger Endgame", R.drawable.endgame, 1),
        Movie(2, "Dr.strange", R.drawable.strange, 1),
        Movie(3, "Iron man", R.drawable.tony, 1),
        Movie(4, "Thor", R.drawable.thor, 1),
    )
}