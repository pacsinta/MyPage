package com.cstcompany.database.impl

import com.cstcompany.database.MainDataRepository
import com.cstcompany.plugins.kmongoData
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

object MainDataMongodbImpl : MainDataRepository{
    private val MyPageDatabase: MongoDatabase = kmongoData.client.getDatabase("MyPage")


    // View counter
    data class ViewCount(val title: String, val count: Int)
    private val counter = MyPageDatabase.getCollection<ViewCount>("ViewCounts")

    override fun getViewCount(title: String): Int {
        return counter.findOne(ViewCount::title eq title)?.count ?: 0
    }
    override fun incrementViewCount(title: String) {
        val count = ViewCount(title, getViewCount(title) + 1)
        counter.insertOne(count)
    }


    // Messages
    data class Message(val name: String, val message: String)
    private val messages = MyPageDatabase.getCollection<Message>("Messages")
    override fun saveMessage(name: String, message: String) {
        messages.insertOne(Message(name, message))
    }

    override fun getMessages(page: Int) {
        messages.find().limit(10).skip((page-1) * 10)
    }
}