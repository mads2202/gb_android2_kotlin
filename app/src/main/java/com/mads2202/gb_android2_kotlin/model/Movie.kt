package com.mads2202.gb_android2_kotlin.model

data class Movie(
    val Title: String,
    var labelPath: String,
    val directors: ArrayList<Director>?,
    val duration: Int,
    val tagline: String,
    var description: String,
    val actors:ArrayList<Actor>?,
    var voteRate:Double
)
