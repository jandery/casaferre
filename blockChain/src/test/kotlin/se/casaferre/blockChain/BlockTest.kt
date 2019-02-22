package se.casaferre.blockChain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class BlockTest {

    data class Doc(val title: String, val description: String)

    @Test
    fun blockOfTypeString_size_3() {
        val block = Block(
                previousHash = "",
                data = listOf("one", "two", "three"),
                nonce = 9,
                hash = "")
        Assertions.assertEquals(block.data.size,3)
    }

    @Test
    fun blockOfTypeDoc_size_2() {
        val docBlock = Block(
                previousHash = "",
                data = listOf(Doc("title1", "decription 1"), Doc("title 2", "description 2")),
                nonce = 0,
                hash = "")
        Assertions.assertEquals(docBlock.data.size, 2)
    }
}