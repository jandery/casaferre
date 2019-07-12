package se.casaferre.webServer.controllers.utils

import freemarker.template.Configuration
import spark.template.freemarker.FreeMarkerEngine
import java.io.File

/**
 * Purpose of this file is ...
 */
class FreemarkerUtil {

    private fun getEngine(location: ResourceLocation): FreeMarkerEngine {
        val config = Configuration(Configuration.VERSION_2_3_26)
        config.setDirectoryForTemplateLoading(File(location.getFreemarkerFiles()))
        return FreeMarkerEngine(config)
    }

    companion object {
        fun getFreemarkerEngine(location: ResourceLocation): FreeMarkerEngine =
                FreemarkerUtil().getEngine(location)
    }
}
