package com.odds.movie.movie

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int, val name: String, val image: String,
    val duration: Int, val description: String
) : Parcelable
