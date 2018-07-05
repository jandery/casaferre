package se.casaferre.data.objects

import java.time.LocalDateTime
import org.bson.types.ObjectId

/**
 * Purpose of this file is representing a data object for monitoring database up for montioring tool
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-05.
 */
data class MonitorDBO(
        val _id: String = ObjectId().toHexString(),
        val value: String,
        val created: LocalDateTime = LocalDateTime.now())