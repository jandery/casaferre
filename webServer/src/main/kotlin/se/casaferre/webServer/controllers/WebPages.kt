package se.casaferre.webServer.controllers

/**
 * Purpose of this file is ...
 */
enum class WebPage(val path: String, val title: String, val fileName: String) {
    CASAFERRE("/", "CasaFerre", "casaferre.ftl"),
    MID("/mid", "MID 99", "lyx.ftl"),
    LYX("/lyx", "Jörgens Lyxfällan", "lyx.ftl")
}