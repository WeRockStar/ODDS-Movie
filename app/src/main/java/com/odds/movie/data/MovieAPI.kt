package com.odds.movie.data

import retrofit2.http.GET

interface MovieAPI {
    @GET("movies")
    suspend fun getMovies(): List<MovieResponse>
}