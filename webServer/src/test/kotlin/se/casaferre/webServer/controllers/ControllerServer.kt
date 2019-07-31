package se.casaferre.webServer.controllers

import org.kodein.di.Kodein
import se.casaferre.webServer.WebServer

/**
 * Purpose of this file is setup a fake Spark server to which we can attach a Controller
 *
 * https://github.com/despegar/spark-test
 * Created by Jorgen Andersson on 2018-03-22.
 */
class ControllerServer(kodein: Kodein) {
    val webServer: WebServer = WebServer(kodein)
}