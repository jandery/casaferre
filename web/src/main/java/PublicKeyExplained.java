import java.math.BigInteger;

/**
 * Purpose of this class ...
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-02-07.
 */
public class PublicKeyExplained {

    public static void main(String[] args) {
        BigInteger clearText = BigInteger.valueOf(72);
        int publicKey = 323;
        int privateKey = 247;
        //
        BigInteger enc = encode(clearText, publicKey);
        BigInteger dec = decode(enc, privateKey, publicKey);
        //
        System.out.println("Clear   " + clearText);
        System.out.println("Encoded " + enc);
        System.out.println("Decoded " + dec);
        //
        BigInteger signed = decode(clearText, privateKey, publicKey);
        BigInteger validated = encode(signed, publicKey);
        System.out.println("Clear     " + clearText);
        System.out.println("Signed    " + signed);
        System.out.println("Validated " + validated);
    }


    /**
     * Formula [Message]^E mod [Public Key]
     * Assuming E = 7
     *
     * @param message   message to encode / validate
     * @param publicKey public key to encode / validate
     * @return
     */
    private static BigInteger encode(BigInteger message, int publicKey) {
        return message.pow(7).mod(BigInteger.valueOf(publicKey));
    }

    /**
     * Formula [Message]^[privateKey] mod [Public Key]
     *
     * @param message    message to decode / sign
     * @param privateKey private key to decode / sign
     * @param publicKey  public key to decode / sign
     * @return
     */
    private static BigInteger decode(BigInteger message, int privateKey, int publicKey) {
        return message.pow(privateKey).mod(BigInteger.valueOf(publicKey));
    }
}
