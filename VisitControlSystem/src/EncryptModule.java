import java.security.PrivateKey;
import java.security.PublicKey;

/*** sample code ***
 public static void main(String[] args) {
     // sender example
     String message = "this is a very important message";
     CAServer caServer = new CAServer();
     EncryptModule encryptModule = new EncryptModule(caServer);
     encryptModule.initKey(new Pair("sender0231", "receiver1532"));
     System.out.println("before encryption: "+message);
     String secretMessage = encryptModule.encryptInfo(message);
     System.out.println("after encryption: "+secretMessage);
     PrivateKey privateKey = encryptModule.getKey().first;

     // receiver example
     EncryptModule decryptModule = new EncryptModule(caServer);
     decryptModule.initKey(privateKey);
     System.out.println("before decryption: "+secretMessage);
     String decryptMessage = decryptModule.decryptInfo(secretMessage);
     System.out.println("after decryption: "+decryptMessage);
 }
*** */

/*** 암호화/복호화 담당하는 모듈 ***/
public class EncryptModule {

    private Pair<PrivateKey, PublicKey> keyPair; // <개인키, 공개키>
    private String encryptType; // 공개키 알고리즘 방식
    private PublicKeyCryptoStrategy cryptoStrategy;
    private CAConnector caConnector;

    EncryptModule(CAServer caServer) {
        this.caConnector = new CAConnector();
        this.caConnector.connectServer(caServer);
        this.encryptType = "RSA"; // default encryptType
        this.cryptoStrategy = PublicKeyFactory.createCryptoStrategy(encryptType);
    }

    EncryptModule(CAServer caServer, String encryptType) {
        this.caConnector = new CAConnector();
        this.caConnector.connectServer(caServer);
        this.encryptType = encryptType;
        this.cryptoStrategy = PublicKeyFactory.createCryptoStrategy(encryptType);
    }

    // (암호화 하는 사람이 사용) connectPair 기반으로 새로운 keyPair 생성, caServer에 keyPair 값 업데이트
    public void initKey(Pair connectPair) {
        keyPair = PublicKeyFactory.createKeyPair(encryptType);
        caConnector.updateKeyPair(connectPair, keyPair);
        cryptoStrategy.init(keyPair);
    }

    // (복호화 하는 사람이 사용) 개인키 기반으로 keyPair 등록
    public void initKey(PrivateKey key) {
        keyPair = new Pair(key, null);
        cryptoStrategy.init(key);
    }

    // 문자열 암호화
    public String encryptInfo(String info) {
        return cryptoStrategy.encrypt(info);
    }

    // 문자열 복호화
    public String decryptInfo(String cipher) {
        return cryptoStrategy.decrypt(cipher);
    }

    public Pair<PrivateKey, PublicKey> getKey() {
        return keyPair;
    }
}
