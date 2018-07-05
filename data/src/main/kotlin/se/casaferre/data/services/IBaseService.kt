package se.casaferre.data.services

/**
 * Purpose of this interface is holding functions needed by all object reading from/writing to database
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-05.
 */
interface IBaseService<T> {
    /**
     * Function to insert a document into database collection
     * @param item to be inserted
     * @return inserted document as object
     */
    fun insert(item: T): T

    /**
     * Function to get list of all documents as object in collection
     * @return all objects in collection
     */
    fun getAll(): List<T>

    /**
     * Function to get one item by its id
     * @param id database id as string for item to retrieve
     * @return object if id exists or null
     */
    fun getById(id: String): T?
}