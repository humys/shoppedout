package com.example.smsreader

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sms_messages")
data class SmsMessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val address: String,
    val body: String,
    val timestamp: Long
)
