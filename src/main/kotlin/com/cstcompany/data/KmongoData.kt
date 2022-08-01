package com.cstcompany.data

import com.cstcompany.MONGODB_CLUSTER
import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo

data class KmongoData(
    val pwd: String,
    val user: String,
    val database: String,
    val client: MongoClient
) {
    constructor(
        pwd: String,
        user: String,
        database: String
    ) : this(
        pwd = pwd,
        user = user,
        database = database,
        client = KMongo.createClient(
            "mongodb+srv://${user}:${pwd}@${MONGODB_CLUSTER}.mongodb.net/${database}?retryWrites=true&w=majority"
        )
    )
}
