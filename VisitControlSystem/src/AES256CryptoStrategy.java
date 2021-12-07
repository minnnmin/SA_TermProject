import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/*** AES256 알고리즘 암/복호화 Strategy Pattern ***/
public class AES256CryptoStrategy implements SymmetricKeyCryptoStrategy {

    private String key;
    private String iv;
    SecretKeySpec keySpec;

    AES256CryptoStrategy() {
        this.key = null;
        this.iv = null;
        this.keySpec = null;
    }

    @Override
    public void init(String inputKey) {
        try {
            this.key = inputKey;
            this.iv = key.substring(0,16);
            byte[] keyBytes = new byte[16];
            byte[] b = key.getBytes("UTF-8");
            int len = b.length;
            if(len> keyBytes.length){
                len = keyBytes.length;
            }
            System.arraycopy(b, 0, keyBytes, 0, len);
            this.keySpec = new SecretKeySpec(keyBytes, "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encrypt(Visitor plain) {
        String cipher = "";
        String plainString = toString(plain);

        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
            byte[] encrypted = c.doFinal(plainString.getBytes());
            cipher = Base64.getEncoder().encodeToString(encrypted);
        } catch (NoSuchAlgorithmException
                | InvalidKeyException
                | InvalidAlgorithmParameterException
                | NoSuchPaddingException
                | BadPaddingException
                | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return cipher;
    }

    @Override
    public Visitor decrypt(String cipher) {
        String plain = "";
        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec((iv.getBytes())));
            byte[] byteStr = Base64.getDecoder().decode(cipher.getBytes());
            plain = new String(c.doFinal(byteStr), "UTF-8");
        } catch (NoSuchAlgorithmException
                | BadPaddingException
                | InvalidKeyException
                | InvalidAlgorithmParameterException
                | NoSuchPaddingException
                | IllegalBlockSizeException
                | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return parseVisitor(plain);
    }

    public String toString(Visitor visitor){
        // <vid>|<vname>|<vage>|<vaddress>|<vcontact>|<vaccination>
        return visitor.getVid()
                +"/"+visitor.getVname()
                +"/"+visitor.getVage()
                +"/"+visitor.getVaddress()
                +"/"+visitor.getVcontact()
                +"/"+visitor.getVaccination();
    }

    public Visitor parseVisitor(String str){
        String[] splitStr = str.split("/");
        return new Visitor(
                Integer.parseInt(splitStr[0]),
                splitStr[1],
                Integer.parseInt(splitStr[2]),
                splitStr[3],
                splitStr[4],
                Vaccination.valueOf(splitStr[5])
        );
    }
}
