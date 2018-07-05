package se.casaferre.webServer.controllers.mocks

import se.casaferre.data.objects.MonitorDBO
import se.casaferre.data.services.IBaseService
import java.util.*

/**
 * Purpose of this class ...
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-05.
 */
class MockedMonitorService : IBaseService<MonitorDBO> {
    val monitorList: MutableList<MonitorDBO> = mutableListOf()

    override fun insert(item: MonitorDBO): MonitorDBO {
        // data classes are immutable, therefore create new with generated id
        val createdItem = MonitorDBO(value = item.value)
        // Add it to list
        monitorList.add(createdItem)
        // return it
        return createdItem
    }

    override fun getAll(): List<MonitorDBO> {
        return monitorList
    }

    override fun getById(id: String): MonitorDBO? {
        return monitorList.find { it._id == id }
    }

    /**
     * Clear database
     */
    fun clear() {
        monitorList.clear()
    }
}