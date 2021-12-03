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

    // Key : UserKey
    // Value : SymmetricKey
    private HashMap<String, String> keyStore;
    private String KEY_PAIR_TYPE = "RSA";

    CAServer(){
        this.keyStore = new HashMap();
    }

    // check connectPair is exists in keyStore
    private boolean isConnectPairExists(String userKey) {
        return keyStore.containsKey(userKey);
    }

    // update to keyStore
    // key: connectPair (with userKey)
    // key: keyPair (with SymmetricKey)
    // "synchronized" option for depending race condition
    public synchronized void updateKeyPair(String userKey, String symmetricKey) {
        keyStore.put(userKey, symmetricKey);
    }

    // get keyPair(SymmetricKey) if connect(userKey) is exists.
    // generate new keyPair if connect is not exists.
    public String getKeyPair(String userKey) {
        if(isConnectPairExists(userKey)){
            return keyStore.get(userKey);
        } else  {
            return null;
        }
    }
}