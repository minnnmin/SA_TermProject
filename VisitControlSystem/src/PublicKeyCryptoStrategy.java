import java.security.PrivateKey;
import java.security.PublicKey;

/*** 공개키 알고리즘 암/복호화 Strategy Pattern ***/
public interface PublicKeyCryptoStrategy {
    void init(Pair<PrivateKey, PublicKey> keyPair);
    void init(PrivateKey privateKey);
    String encrypt(String plain);
    String decrypt(String cipher);
}
