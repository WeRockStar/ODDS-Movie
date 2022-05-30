package com.odds.movie.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.odds.movie.R
import com.odds.movie.databinding.ActivityMovieBinding
import com.odds.movie.login.User

class MovieActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMovieBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bind()
    }

    private fun bind() {
        val user = intent.getParcelableExtra<User>(EXTRA_USER)
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        with(binding) {
            tvMovieName.text = movie?.name.orEmpty()
            tvDuration.text = getString(R.string.duration).format(movie?.duration)
            tvGreeting.text = getString(R.string.greeting).format(user?.username.orEmpty())
            imageView.setImageResource(movie?.image ?: R.drawable.endgame)
        }
    }

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }
}

