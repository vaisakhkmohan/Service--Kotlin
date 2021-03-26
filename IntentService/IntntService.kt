package com.vaisakh.hustler.service_kotlin

import android.app.IntentService
import android.content.Intent
import android.os.SystemClock
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class IntntService : IntentService("name") {

    override fun onHandleIntent(intent: Intent?) {

        val message = intent!!.getStringExtra("message")
        intent!!.action = MainActivity.FILTER_ACTION_KEY
        SystemClock.sleep(3000)
        val echoMessage = "IntentService after a pause of 3 seconds echoes $message"

        LocalBroadcastManager.getInstance(applicationContext)
            .sendBroadcast(intent!!.putExtra("broadcastMessage", echoMessage))
    }


}