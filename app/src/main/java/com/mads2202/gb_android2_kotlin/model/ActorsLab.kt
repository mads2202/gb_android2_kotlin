package com.mads2202.gb_android2_kotlin.model

import java.util.*

object ActorsLab {
    val actors = arrayListOf<Actor>()
    fun myCopy() {
        var actor = Actor(
            "Harrison Ford", arrayListOf(
                Movie(
                    "Indiana Jons", "null", null, 1, "2", "3",
                    null, 8.0
                )
            ), Date()
        )
        print(actor.copy())

    }
}