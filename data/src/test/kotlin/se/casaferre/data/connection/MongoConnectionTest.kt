package se.casaferre.data.connection

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MongoConnectionTest {

    @BeforeEach
    internal fun setupBeforeEachMethod() {
        MongoConnection.resetDatabase()
    }


    @Test
    fun mongoConnectionGetDatabase_name_hovno() {
        MongoConnection.setConnection("mongodb://localhost:27017/xyz")
        Assertions.assertEquals(MongoConnection.getDatabase().name,"xyz")
    }

    @Test
    fun mongoConnection_testTwoConnections_thereCanOnlyBeOneConnectionShouldThrowException() {
        val expectedExceptionMessage = "There is already a connection to a DB!"
        try {
            // Set first connection
            MongoConnection.setConnection("mongodb://localhost:27017/xyz")
            // Try to set another connection
            MongoConnection.setConnection("mongodb://localhost:27017/abc")
        } catch (e: RuntimeException) {
            Assertions.assertEquals(e.message,expectedExceptionMessage)
        }
    }
}