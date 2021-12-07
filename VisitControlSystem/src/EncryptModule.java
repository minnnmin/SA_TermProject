import java.security.PrivateKey;
import java.security.PublicKey;

/*** sample code ***
 public static void main(String args[]) {
     // init
     String message = "super secret my long long messages";
     String enc_userName = "xemic";
     CAServer caServer = new CAServer();
     EncryptModule encryptModule = new EncryptModule(caServer);

     // encrypt
     String symmetricKey = encryptModule.generateKey(enc_userName);
     System.out.println("before encrypt : "+symmetricKey);
     encryptModule.initKey(symmetricKey);
     System.out.println("before encrypt : "+message);
     String encMessage = encryptModule.encryptInfo(message);
     System.out.println("after encrypt : "+encMessage);

     // decrypt
     EncryptModule decryptModule = new EncryptModule(caServer);
     decryptModule.initKey(symmetricKey);
     System.out.println("before decrypt : "+encMessage);
     String decMessage = decryptModule.decryptInfo(encMessage);
     System.out.println("after decrypt : "+decMessage);
 }
*** */

/*** 암호화/복호화 담당하는 모듈 ***/
public class EncryptModule {

    private String symmetricKey; // 대칭키
    private String encryptType; // 대칭키 알고리즘 방식
    private SymmetricKeyCryptoStrategy cryptoStrategy;
    private CAConnector caConnector;

    EncryptModule(CAServer caServer) {
        this.symmetricKey = null;
        this.caConnector = new CAConnector();
        this.caConnector.connectServer(caServer);
        this.encryptType = "AES256"; // default encryptType
        this.cryptoStrategy = SymmetricKeyFactory.createCryptoStrategy(encryptType);
    }

    EncryptModule(CAServer caServer, String encryptType) {
        this.symmetricKey = null;
        this.caConnector = new CAConnector();
        this.caConnector.connectServer(caServer);
        this.encryptType = encryptType;
        this.cryptoStrategy = SymmetricKeyFactory.createCryptoStrategy(encryptType);
    }

    // (암호화 하는 사람이 사용) userKey 기반으로 새로운 symmetricKey 생성, caServer에 symmetricKey 값 업데이트
    public String generateKey(String userInfo) {
        symmetricKey = SymmetricKeyFactory.createKey(encryptType, userInfo);
        caConnector.updateKeyPair(userInfo, symmetricKey);
        return symmetricKey;
    }

    // (암호화 하는 사람이 사용) userKey 기반으로 새로운 symmetricKey 생성, caServer에 symmetricKey 값 업데이트
    public void initKey(String symmetricKey) {
        cryptoStrategy.init(symmetricKey);
    }

    // 문자열 암호화
    public String encryptInfo(Visitor info) {
        return cryptoStrategy.encrypt(info);
    }

    // 문자열 복호화
    public Visitor decryptInfo(String cipher) {
        return cryptoStrategy.decrypt(cipher);
    }

    public String getKey() {
        return symmetricKey;
    }
}
