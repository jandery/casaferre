package se.casaferre.data.connection

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class MongoConnectionTest {

    @Before
    fun setupBeforeEachMethod() {
        MongoConnection.resetDatabase()
    }


    @Test
    fun mongoConnectionGetDatabase_name_hovno() {
        MongoConnection.setConnection("mongodb://localhost:27017/xyz")
        assertThat(MongoConnection.getDatabase().name).isEqualTo("xyz")
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
            assertThat(e.message).isEqualTo(expectedExceptionMessage)
        }
    }
}