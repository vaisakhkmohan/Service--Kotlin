package com.vaisakh.hustler.service_kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myReceiver: MyReceiver? = null
    companion object {
        val FILTER_ACTION_KEY = "any_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendmessage(view: View) {
        val message = inputText.getText().toString()
        val intent = Intent(this@MainActivity, IntntService::class.java)
        intent.putExtra("message", message)
        startService(intent)
    }

    private fun setReceiver() {
        myReceiver = MyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(FILTER_ACTION_KEY)
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver!!, intentFilter)
    }

    override fun onStart() {
        setReceiver()
        super.onStart()
    }

    override fun onStop() {
        unregisterReceiver(myReceiver)
        super.onStop()
    }

    class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val message = intent.getStringExtra("broadcastMessage")
            Log.e("TAG", "onReceive: $message" )
        }
    }

}