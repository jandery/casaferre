package se.casaferre.webServer.controllers.utils

/**
 * Purpose of this file is ...
 */
class PropertyUtil {

    companion object {

        /**
         * Function to read Maven Pom message
         */
        fun readHejmo(): String =
                System.getProperty("hejmo") ?: "Kotlin class default"
    }
}