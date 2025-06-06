package com.example.smsreader

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SmsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(message: SmsMessageEntity)

    @Query("SELECT * FROM sms_messages WHERE address = :address")
    fun getMessagesFromAddress(address: String): List<SmsMessageEntity>
}
