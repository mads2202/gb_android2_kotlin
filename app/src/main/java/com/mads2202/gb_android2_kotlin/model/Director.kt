package com.mads2202.gb_android2_kotlin.model

import java.util.*
import kotlin.collections.ArrayList

data class Director(var name:String,val dateBorn:Date, val movies:ArrayList<Movie>) {
}