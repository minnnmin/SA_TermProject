/*** CAServer 와 연결을 담당하는 CAConnector ***/
public class CAConnector {

    private CAServer caServer;

    CAConnector() {
        this.caServer = null;
    }

    // caServer 연결
    public void connectServer(CAServer caServer){
        this.caServer = caServer;
    }

    // caServer 에 새로운 keyPair를 업데이트
    public void updateKeyPair(String userKey, String symmetricKey) {
        caServer.updateKeyPair(userKey, symmetricKey);
    }

    // caServer 에서 key,value 기반으로 keyPair 반환받기
    public String getKey(String userKey) {
        return caServer.getKeyPair(userKey);
    }
}
