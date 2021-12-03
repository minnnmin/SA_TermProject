import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/*** RSA 알고리즘 암/복호화 Strategy Pattern ***/
public class RSACryptoStrategy implements PublicKeyCryptoStrategy {

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    RSACryptoStrategy() {
        this.privateKey = null;
        this.publicKey = null;
    }

    @Override
    public void init(Pair<PrivateKey, PublicKey> keyPair) {
        this.privateKey = (RSAPrivateKey) keyPair.first;
        this.publicKey = (RSAPublicKey) keyPair.second;
    }

    @Override
    public void init(PrivateKey privateKey) {
        this.privateKey = (RSAPrivateKey) privateKey;
    }

    @Override
    public String encrypt(String plain) {
        String cipher = "";
        try {
            Cipher encCipher = Cipher.getInstance("RSA");
            encCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipher = Base64.getEncoder().encodeToString(
                    encCipher.doFinal(plain.getBytes())
            );
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException
                | BadPaddingException
                | IllegalBlockSizeException
                | InvalidKeyException e) {
            e.printStackTrace();
        }
        return cipher;
    }

    @Override
    public String decrypt(String cipher) {
        String plain = "";
        try {
            Cipher decCipher = Cipher.getInstance("RSA");
            decCipher.init(Cipher.DECRYPT_MODE, privateKey);
            plain = new String(
                    decCipher.doFinal(Base64.getDecoder().decode(cipher)),
                    "utf-8"
            );
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException
                | BadPaddingException
                | IllegalBlockSizeException
                | InvalidKeyException
                | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return plain;
    }
}
