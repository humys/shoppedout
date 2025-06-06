package com.example.smsreader

import android.Manifest
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {
    private lateinit var repository: SmsRepository
    private lateinit var receiver: SMSReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main) // layout placeholder

        // Example short codes; in real app, ask user and store
        val shortCodes = setOf("7220", "14250")
        val dao = AppDatabase.getDatabase(this).smsDao()
        repository = SmsRepository(dao, shortCodes)
        receiver = SMSReceiver(repository)

        requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS), 0)
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        registerReceiver(receiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}
