package se.casaferre.data.connection

import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

/**
 * Purpose of this class ...
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-06-27.
 */
object MongoConnection {
    private var DATABASE: MongoDatabase? = null


    fun setConnection(hostUrl: String) {
        val clientURI = MongoClientURI(hostUrl)
        DATABASE = KMongo
                .createClient(clientURI)
                .getDatabase(clientURI.database)
    }

    fun getDatabase(): MongoDatabase {
        @Suppress("UNCHECKED_CAST")
        return DATABASE as MongoDatabase
    }

    fun resetDatabase() {
        DATABASE = null
    }
}