package com.mads2202.gb_android2_kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
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
        val receiver=object:BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                println("FROM SERVICE:" +
                        " ${intent?.getBooleanExtra(MainService.INTENT_NAME,
                            false)}")
            }
        }

        supportFragmentManager.beginTransaction().add(R.id.container,MovieListFragment()).commit()


    }
}