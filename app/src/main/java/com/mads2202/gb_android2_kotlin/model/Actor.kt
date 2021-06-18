package com.mads2202.gb_android2_kotlin.model

import java.util.*
import kotlin.collections.ArrayList

data class Actor(var name:String, val movies:ArrayList<Movie>, val dateBorn: Date)
