import java.time.LocalDateTime;
import java.util.ArrayList;

public class HHandler {

    private SearchProcessModule searchProcessModule;
    private EncryptModule encryptModule;

    HHandler(SearchProcessModule searchProcessModule, EncryptModule encryptModule) {
        this.searchProcessModule = searchProcessModule;
        this.encryptModule = encryptModule;
        initEncryptModule();
    }

    public void sendMessage(String message) {
        // TODO implement here
    }


    public ArrayList<Facility> searchFacilityList(Visitor visitor, String startTime, String endTime) {
        return searchProcessModule.searchFacilityList(visitor, startTime, endTime);
    }

    public ArrayList<String> searchVisitorList(Facility facility, String startTime, String endTime) {
        return searchProcessModule.searchVisitorList(facility, startTime, endTime);
    }

    private void initEncryptModule(){
        String symKey = "";
        if(encryptModule.getKey() == null)
            symKey = encryptModule.generateKey("cHandleKey");
        else
            symKey = encryptModule.getKey();
        encryptModule.initKey(symKey);

    }
}
