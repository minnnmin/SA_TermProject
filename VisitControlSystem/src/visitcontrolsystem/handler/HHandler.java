package visitcontrolsystem.handler;

import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.Visitor;
import visitcontrolsystem.model.HMessage;
import visitcontrolsystem.module.EncryptModule;
import visitcontrolsystem.module.SearchProcessModule;
import visitcontrolsystem.module.NotificationControlModule;
import java.util.ArrayList;

public class HHandler {

    private SearchProcessModule searchProcessModule;
    private EncryptModule encryptModule;
    private NotificationControlModule notiModule;

    public HHandler(SearchProcessModule searchProcessModule, EncryptModule encryptModule, NotificationControlModule notiModule) {
        this.searchProcessModule = searchProcessModule;
        this.encryptModule = encryptModule;
        this.notiModule = notiModule;
        initEncryptModule();
    }

    public void sendMessage(HMessage message) {    	
        this.notiModule.sendMessage(message);    	
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
