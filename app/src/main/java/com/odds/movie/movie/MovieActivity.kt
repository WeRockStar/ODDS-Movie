package com.odds.movie.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.odds.movie.R
import com.odds.movie.databinding.ActivityMovieBinding
import com.odds.movie.login.User

class MovieActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMovieBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nav = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = nav.navController
        navController.setGraph(R.navigation.movie_navigation, intent.extras)
    }

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }
}

