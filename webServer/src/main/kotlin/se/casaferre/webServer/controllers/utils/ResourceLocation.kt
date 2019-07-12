package se.casaferre.webServer.controllers.utils

/**
 * Purpose of this file is ...
 */
private val userDir: String = System.getProperty("user.dir")


enum class ResourceLocation(val location: String) {
    RUN("$userDir/webServer/target/classes"),
    DEV("$userDir/webServer/src/main/resources");

    fun getStaticFiles(): String = "/www"

    fun getFreemarkerFiles(): String = "$location/spark/template/freemarker"
}