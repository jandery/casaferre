package se.casaferre.usb

import org.usb4java.Context
import org.usb4java.DeviceList
import org.usb4java.LibUsb

/**
 * Purpose of this file is ...
 */
class JojjeUsb {

    init {

    }

    fun setupUsb() {
        val context: Context = Context()
        val result: Int = LibUsb.init(context)
    }

    companion object {
        fun getDeviceList() {
            val deviceList: DeviceList = DeviceList()
            val result: Int = LibUsb.getDeviceList(null, deviceList)
        }
    }
}