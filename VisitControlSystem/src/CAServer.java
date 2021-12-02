import java.security.*;
import java.util.HashMap;

// Todo : Connector 가 둘의 키를 교환해줌.
// Todo : 클라이언트와 서버가 비대칭키 각각 만들어서 서로 양방향 통신 준비
// Todo : 클라와 서버 대칭키 주고 받음
// Todo : 앞으로 오로고가는 데이터들 모두 대칭키로 주고받음

/*** 인증서를 발급하는 CAServer ***/
public class CAServer {

    // Key : <Client, Server>
    // Value : <Private key, Public key>
    private HashMap<Pair<String, String>, Pair<PrivateKey, PublicKey>> keyStore;

    CAServer(){
        keyStore = new HashMap();
    }

    // get keyPair(PrivateKey and PublicKey) if connect(Pair of Client and Server) is exists.
    // generate new keyPair if connect is not exists.
    public Pair<PrivateKey, PublicKey> getKeyPair(Pair<String, String> connectPair) {
        if(isConnectPairExists(connectPair)){
            return keyStore.get(connectPair);
        } else {
            Pair<PrivateKey, PublicKey> keyPair = generateKeyPair(); // generate new key pair
            updateKeyPair(connectPair, keyPair); // update to keyStore
            return keyPair;
        }
    }

    // update to keyStore
    // key: connectPair (with Client and Server)
    // key: keyPair (with PrivateKey and PublicKey)
    private void updateKeyPair(Pair<String, String> connectPair, Pair<PrivateKey, PublicKey> keyPair) {
        keyStore.put(connectPair, keyPair);
    }

    // check connectPair is exists in keyStore
    private boolean isConnectPairExists(Pair<String, String> connectPair) {
        return keyStore.containsKey(connectPair);
    }

    // generate
    private Pair<PrivateKey, PublicKey> generateKeyPair() {
        return PublicKeyFactory.createKeyPair("RSA");
    }
}

/***
 * CA 가 인증서 발급, 개인키를 이용하여.
 * 나머진 공개키를 가지고 있음. 그리고 이를 이용해서 복호화 함
 * > 복호화 성공시 CA 에서 발급한게 맞음
 * 그리고 인증서는 서버가 클라에게 제공
 * 인증서에는 서버의 공개키가 포하되어있음
 ***/