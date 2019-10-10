package se.casaferre.webServer.controllers.api

import spark.Request
import spark.Response
import java.io.File
import javax.swing.filechooser.FileSystemView


/**
 * Purpose of this file is ...
 */
class UsbController {

    data class DriveInfo(val type: String, val totalSpace: Long, val freeSpace: Long)

    companion object {

        val readFileSystem = { _: Request, _: Response ->
            val fsv = FileSystemView.getFileSystemView()
            val drives = File.listRoots()
            if (!drives.isNullOrEmpty()) {
                drives
                        .map {
                            DriveInfo(fsv.getSystemTypeDescription(it), it.totalSpace, it.freeSpace)
                        }
                        .toString()
            } else {
                ""
            }
        }
    }


}