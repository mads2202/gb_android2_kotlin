package com.mads2202.gb_android2_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.mads2202.gb_android2_kotlin.model.ActorsLab

class MainActivity : AppCompatActivity() {
    lateinit var button:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
        button.setOnClickListener{
            Toast.makeText(this,"Button wa Clicked!",Toast.LENGTH_SHORT).show()
            for(i in 1..10) {
                print("Hello Kotlin!")
            }
            for(i in 10 downTo 1 step 2) {
                print("Hello Kotlin!")
            }
            ActorsLab.myCopy()

        }
    }
}