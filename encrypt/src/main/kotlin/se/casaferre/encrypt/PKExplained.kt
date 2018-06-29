package se.casaferre.encrypt

import java.math.BigInteger

/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
object PublicKeyExplained {

    @JvmStatic
    fun main(args: Array<String>) {
        val clearText = BigInteger.valueOf(72)
        val publicKey = 323
        val privateKey = 247
        //
        val enc = encode(clearText, publicKey)
        val dec = decode(enc, privateKey, publicKey)
        //
        println("Clear   $clearText")
        println("Encoded $enc")
        println("Decoded $dec")
        //
        val signed = decode(clearText, privateKey, publicKey)
        val validated = encode(signed, publicKey)
        println("Clear     $clearText")
        println("Signed    $signed")
        println("Validated $validated")
    }


    /**
     * Formula [Message]^E mod [Public Key]
     * Assuming E = 7
     *
     * @param message   message to encode / validate
     * @param publicKey public key to encode / validate
     * @return
     */
    private fun encode(message: BigInteger, publicKey: Int): BigInteger {
        return message.pow(7).mod(BigInteger.valueOf(publicKey.toLong()))
    }

    /**
     * Formula [Message]^[privateKey] mod [Public Key]
     *
     * @param message    message to decode / sign
     * @param privateKey private key to decode / sign
     * @param publicKey  public key to decode / sign
     * @return
     */
    private fun decode(message: BigInteger, privateKey: Int, publicKey: Int): BigInteger {
        return message.pow(privateKey).mod(BigInteger.valueOf(publicKey.toLong()))
    }
}
