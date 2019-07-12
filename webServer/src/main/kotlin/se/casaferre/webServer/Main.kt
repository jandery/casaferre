package se.casaferre.webServer

import io.schinzel.basicutils.configvar.ConfigVar
import io.schinzel.basicutils.configvar.IConfigVar
import se.casaferre.data.connection.MongoConnection
import se.casaferre.webServer.controllers.utils.ResourceLocation

/**
 * Purpose of this file is to start a WebServer
 *
 * Created by Jorgen Andersson on 2018-06-26.
 */
fun main() {

    val config : IConfigVar = ConfigVar.create(".env")
    val port = Integer.parseInt(config.getValue("PORT"))

    MongoConnection.setConnection(config.getValue("MONGOHQ_URL"))

    WebServer()

    println("************************************************")
    println("*****  Spark server started on port $port  ******")
    println("************************************************")
}