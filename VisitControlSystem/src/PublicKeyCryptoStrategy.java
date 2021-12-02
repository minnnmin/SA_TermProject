import java.security.PrivateKey;
import java.security.PublicKey;

public interface PublicKeyCryptoStrategy {
    void init(Pair<PrivateKey, PublicKey> keyPair);
    String encrypt(String plain);
    String decrypt(String cipher);
}
