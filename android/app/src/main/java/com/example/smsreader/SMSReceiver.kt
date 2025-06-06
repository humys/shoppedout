package com.example.smsreader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony

class SMSReceiver(private val repository: SmsRepository): BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION == intent.action) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            for (msg in messages) {
                val address = msg.displayOriginatingAddress
                val body = msg.messageBody
                val timestamp = msg.timestampMillis
                // Filter by configured short codes
                if (repository.isBankShortCode(address)) {
                    repository.saveSms(address, body, timestamp)
                }
            }
        }
    }
}
