package com.mads2202.gb_android2_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.mads2202.gb_android2_kotlin.model.ActorsLab

class MainActivity : AppCompatActivity() {
    lateinit var button: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}