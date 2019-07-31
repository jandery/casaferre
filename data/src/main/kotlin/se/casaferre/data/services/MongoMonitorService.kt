package se.casaferre.data.services

import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection
import org.litote.kmongo.toList
import se.casaferre.data.connection.MongoConnection
import se.casaferre.data.objects.MonitorDBO

/**
 * Purpose of this Service is reading/writing MonitorItems to database
 * Its recommended that monitor collection is capped
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-05.
 */
class MongoMonitorService : IBaseService<MonitorDBO> {
    // Get MongoDatabase
    private val database = MongoConnection.getDatabase()
    // MongoCollection
    protected val collection = database.getCollection<MonitorDBO>("monitor")


    override fun insert(item: MonitorDBO): MonitorDBO {
        return item.apply {
            collection.insertOne(item)
        }
    }

    override fun getById(id: String): MonitorDBO? {
        return collection.findOneById(id)
    }

    override fun getAll(): List<MonitorDBO> {
        return collection.find().toList()
    }


}