import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        CAServer caServer = new CAServer();
//        // RSA key 만들기
//        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
//        generator.initialize(512);
//        KeyPair keyPair = generator.generateKeyPair();
//        RSAPrivateKey priv = (RSAPrivateKey) keyPair.getPrivate();
//        RSAPublicKey pub = (RSAPublicKey) keyPair.getPublic();
//        System.out.println(priv.toString());
//        System.out.println(pub.toString());
//
//        // RSA Encrypt
//        Cipher encCipher = Cipher.getInstance("RSA");
//        encCipher.init(Cipher.ENCRYPT_MODE, pub);
//        String plainText = "test";
//        System.out.println("plain: "+plainText);
//
//        String encText = Base64.getEncoder().encodeToString(
//                encCipher.doFinal(plainText.getBytes())
//        );
//        System.out.println("encText: "+encText);
//
//        // RSA Decrpyt
//        Cipher decCipher = Cipher.getInstance("RSA");
//        decCipher.init(Cipher.DECRYPT_MODE, priv);
//        System.out.println("encText: "+encText);
//
//        String decText = new String(
//            decCipher.doFinal(
//                Base64.getDecoder().decode(encText)
//            ),
//            "utf-8"
//        );
//        System.out.println("decText: "+decText);
    }
}
