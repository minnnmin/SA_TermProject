import java.util.HashMap;

/*** 인증서를 발급하는 CAServer ***/
public class CAServer {

    // Key : UserKey
    // Value : SymmetricKey
    private HashMap<String, String> keyStore;
    private String KEY_PAIR_TYPE = "RSA";

    CAServer(){
        this.keyStore = new HashMap();
    }

    // check userKey is exists in keyStore
    private boolean isConnectPairExists(String userKey) {
        return keyStore.containsKey(userKey);
    }

    // update to keyStore
    // key: userKey
    // value: SymmetricKey
    // "synchronized" option for depending race condition
    public synchronized void updateKeyPair(String userKey, String symmetricKey) {
        keyStore.put(userKey, symmetricKey);
    }

    // get SymmetricKey if userKey is exists.
    // generate new SymmetricKey if userKey is not exists.
    public String getKeyPair(String userKey) {
        if(isConnectPairExists(userKey)){
            return keyStore.get(userKey);
        } else  {
            return null;
        }
    }
}