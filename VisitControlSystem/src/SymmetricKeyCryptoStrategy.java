import java.security.PrivateKey;
import java.security.PublicKey;

/*** 대칭키 알고리즘 암/복호화 Strategy Pattern ***/
public interface SymmetricKeyCryptoStrategy {
    void init(String inputKey);
    String encrypt(Visitor plain);
    Visitor decrypt(String cipher);
}
