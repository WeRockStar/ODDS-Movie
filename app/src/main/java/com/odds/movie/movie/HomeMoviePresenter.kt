package com.odds.movie.movie

import com.odds.movie.data.MovieAPI
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class HomeMoviePresenter constructor(private val api: MovieAPI) {

    private val scope = MainScope()
    private lateinit var view: HomeMovieView

    fun attachView(view: HomeMovieView) {
        this.view = view
    }

    interface HomeMovieView {
        fun showMovies(movies: List<Movie>)
    }

    fun fetchMovie() {
        scope.launch {
            val movies = api.getMovies()
                .map {
                    Movie(
                        it.id, it.name,
                        it.image, it.duration, it.description
                    )
                }
            view.showMovies(movies)
        }
    }
}