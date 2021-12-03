import java.security.*;
import java.util.HashMap;

/*** CA 사용 시나리오 ***
 * Client 가 CAServer에게 KeyPair를 받는다.
 * keyPair 로 PublicKeyCryptoStrategy init() 후 보내고자하는 정보를 encrypt 한다.
 * encrypt 된 정보와 pubicKey를 함께 보내준다.
 * 받는쪽에선 publicKey 로 PublicKeyCryptoStrategy init() 후 전송받은 encrypt 된 정보를 복호화한다.
 * ***/

/*** 인증서를 발급하는 CAServer ***/
public class CAServer {

    // Key : <Sender, Receiver>
    // Value : <Private key, Public key>
    private HashMap<Pair<Object, Object>, Pair<PrivateKey, PublicKey>> keyStore;
    private String KEY_PAIR_TYPE = "RSA";
    public String test = "test";

    CAServer(){
        this.keyStore = new HashMap();
    }

    // check connectPair is exists in keyStore
    private boolean isConnectPairExists(Pair<Object, Object> connectPair) {
        return keyStore.containsKey(connectPair);
    }

    // update to keyStore
    // key: connectPair (with Sender and Receiver)
    // key: keyPair (with PrivateKey and PublicKey)
    // "synchronized" option for depending race condition
    public synchronized void updateKeyPair(Pair<Object, Object> connectPair, Pair<PrivateKey, PublicKey> keyPair) {
        keyStore.put(connectPair, keyPair);
    }

    // get keyPair(PrivateKey and PublicKey) if connect(Pair of Sender and Receiver) is exists.
    // generate new keyPair if connect is not exists.
    public Pair<PrivateKey, PublicKey> getKeyPair(Pair<Object, Object> connectPair) {
        if(isConnectPairExists(connectPair)){
            return keyStore.get(connectPair);
        } else  {
            return null;
        }
    }
}