package com.odds.movie.data

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("description")
    val description: String,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("genre")
    val genre: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("year")
    val year: Int
)
