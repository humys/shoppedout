package com.example.smsreader

class SmsRepository(private val dao: SmsDao, private val shortCodes: Set<String>) {
    fun isBankShortCode(address: String): Boolean = shortCodes.contains(address)

    fun saveSms(address: String, body: String, timestamp: Long) {
        val entity = SmsMessageEntity(address = address, body = body, timestamp = timestamp)
        dao.insert(entity)
    }
}
