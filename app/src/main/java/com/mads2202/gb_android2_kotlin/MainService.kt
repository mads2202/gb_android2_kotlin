package com.mads2202.gb_android2_kotlin

import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

private const val TAG = "MainServiceTAG"
const val MAIN_SERVICE_STRING_EXTRA = "MainServiceExtra"

class MainService(name: String = "MainService") : JobIntentService() {
    companion object{
        const val INTENT_NAME="INTENTNAME"
    }

    override fun onHandleWork(intent: Intent) {
        createLogMessage("onHandleIntent ${intent?.getStringExtra(MAIN_SERVICE_STRING_EXTRA)}")
    }

    override fun onCreate() {
        createLogMessage("onCreate")
        val intent=Intent()
        intent.putExtra(INTENT_NAME,"HELLO WORLD!")
        sendBroadcast(intent)
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createLogMessage("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        createLogMessage("onDestroy")
        super.onDestroy()
    }

    //Выводим уведомление в строке состояния
    private fun createLogMessage(message: String) {
        Log.d(TAG, message)
    }
}