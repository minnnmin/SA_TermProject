import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/*** 대칭키 관련 키를 만들어주고, Strategy 패턴도 만들어주는 Factory Pattern ***/
public class SymmetricKeyFactory {

    public static String createKey(String type, String key){
        if(type.equals("AES256")) {
            // AES256 Type
            String hashKey = String.valueOf(key.hashCode() & 0x7fffffff);
            String hashKey2 = String.valueOf(hashKey.hashCode() & 0x7fffffff);
            return hashKey+hashKey2;
        } else {
            // invalid Type
            return null;
        }
    }

    public static SymmetricKeyCryptoStrategy createCryptoStrategy(String type){
        if(type.equals("AES256")) {
            // AES256 Type
            return new AES256CryptoStrategy();
        } else {
            // invalid Type
            return null;
        }
    }
}
