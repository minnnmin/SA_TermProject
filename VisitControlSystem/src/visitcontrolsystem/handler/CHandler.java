package visitcontrolsystem.handler;

import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.Visitor;
import visitcontrolsystem.module.EncryptModule;
import visitcontrolsystem.module.VisitlistControlModule;

public class CHandler {

    private VisitlistControlModule visitlistControlModule;
    private EncryptModule encryptModule;

    public CHandler(VisitlistControlModule visitlistControlModule, EncryptModule encryptModule) {
        this.visitlistControlModule = visitlistControlModule;
        this.encryptModule = encryptModule;
        initEncryptModule();
    }
    public void addVisitorInfo(Facility facility, Visitor visitor, String visitedTime) {
        String visitorEnc = encryptModule.encryptInfo(visitor);
        visitlistControlModule.addVisitorInfo(facility, visitor.getVid(), visitorEnc, visitedTime);
    }

    private void initEncryptModule(){
        String symKey = "";
        if(encryptModule.getKey() == null)
            symKey = encryptModule.generateKey("cHandleKey");
        else
            symKey = encryptModule.getKey();
        encryptModule.initKey(symKey);

    }

    // Test 용
    public void printVisitorsOf(Facility facility) {
        visitlistControlModule.printVisitorsOf(facility);
    }

    public void showMessage(String message) {
        // TODO implement here
    }
}
