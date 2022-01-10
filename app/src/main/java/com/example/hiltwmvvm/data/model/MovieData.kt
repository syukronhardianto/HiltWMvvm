package com.example.hiltwmvvm.data.model

//import androidx.room.Entity
//import androidx.room.PrimaryKey

//@Entity(tableName = "movie_tbl")
data class MovieData(
//    @PrimaryKey
    val id: Int = 0,
    val adult: Boolean = false,
    val backdrop_path: String? = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val vote_average: Float = 0f
)