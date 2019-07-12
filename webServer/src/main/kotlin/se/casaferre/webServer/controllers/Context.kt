package se.casaferre.webServer.controllers

import io.schinzel.basicutils.configvar.ConfigVar
import io.schinzel.basicutils.configvar.IConfigVar
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider


private val config : IConfigVar = ConfigVar.create(".env")

enum class ContextVariable {
    PORT,
    MONGO_URL,
    FILES_LOCATION
}

val wwwContext = Kodein {

    bind<Boolean>() with provider {
        System.getProperty("run_mode") != "run"
    }

    bind<Int>(ContextVariable.PORT) with provider {
        Integer.parseInt(config.getValue(ContextVariable.PORT.name))
    }

    bind<String>(ContextVariable.MONGO_URL) with provider {
        config.getValue(ContextVariable.MONGO_URL.name)
    }
}