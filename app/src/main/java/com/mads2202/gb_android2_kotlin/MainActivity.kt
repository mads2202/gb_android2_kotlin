package com.mads2202.gb_android2_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.mads2202.gb_android2_kotlin.model.ActorsLab

class MainActivity : AppCompatActivity() {
    lateinit var button: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //тренировка дз4
        fun View.createAndShow(text: String, actionText: String, action: (View) -> Unit, length: Int = Snackbar.LENGTH_INDEFINITE) {
            Snackbar.make(this, text, length).setAction(actionText, action).show()}


    }
}