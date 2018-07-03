package se.casaferre

import io.schinzel.basicutils.configvar.ConfigVar
import io.schinzel.basicutils.configvar.IConfigVar
import se.casaferre.data.connection.MongoConnection
import se.casaferre.webServer.WebServer

/**
 * Purpose of this file is to start a WebServer
 *
 * Created by Jorgen Andersson on 2018-06-26.
 */
fun main(args: Array<String>) {

    val config : IConfigVar = ConfigVar.create(".env")
    val port = Integer.parseInt(config.getValue("PORT"))
    val environment = config.getValue("ENVIRONMENT")
    val filesLocation = "/www"

    MongoConnection.setConnection(config.getValue("MONGOHQ_URL"))

    WebServer(
            port = port,
            environment = environment,
            filesLocation = filesLocation)

    println("************************************************")
    println("*****  Spark server started on port $port  ******")
    println("************************************************")
}