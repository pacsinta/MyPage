package com.cstcompany.database

interface MainDataRepository {
    fun getViewCount(title: String): Int
    fun incrementViewCount(title: String)

    fun saveMessage(name: String, message: String)
    fun getMessages(page: Int)
}

