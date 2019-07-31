package se.casaferre.webServer.controllers

import freemarker.template.Configuration
import io.schinzel.basicutils.configvar.ConfigVar
import io.schinzel.basicutils.configvar.IConfigVar
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import se.casaferre.webServer.controllers.utils.ResourceLocation
import spark.template.freemarker.FreeMarkerEngine
import java.io.File


private val config : IConfigVar = ConfigVar.create(".env")
private val isTest : Boolean = System.getProperty("run_mode") != "run"

enum class ContextVariable {
    PORT,
    BASE_URL,
    MONGO_URL
}

data class ServerSettings(val port: Int, val url: String)

val wwwContext = Kodein {
    val port = Integer.parseInt(config.getValue(ContextVariable.PORT.name))

    bind<ServerSettings>() with provider {
        ServerSettings(port, config.getValue(ContextVariable.BASE_URL.name))
    }

    bind<FreeMarkerEngine>() with provider {
        FreeMarkerEngine()
    }

    bind<String>(ContextVariable.MONGO_URL) with provider {
        val suffix = if (isTest) "_$port" else ""
        config.getValue(ContextVariable.MONGO_URL.name) + suffix
    }
}