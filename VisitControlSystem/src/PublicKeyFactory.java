import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/*** 공개키를 만들어주는 Factory Pattern ***/
public class PublicKeyFactory {
    // RSA Key pair size
    private static final int RSA_KEY_PAIR_SIZE = 512;

    public static Pair<PrivateKey, PublicKey> createKeyPair(String type){
        if(type.equals("RSA")) {
            // RSA type
            try {
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
                generator.initialize(RSA_KEY_PAIR_SIZE);
                KeyPair keyPair = generator.generateKeyPair();
                RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
                RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
                return new Pair(privateKey, publicKey);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            // invalid type
            return null;
        }
    }

    public static PublicKeyCryptoStrategy createCryptoStrategy(String type){
        if(type.equals("RSA")) {
            // RSA Type
            return new RSACryptoStrategy();
        } else {
            // invalid Type
            return null;
        }
    }
}
