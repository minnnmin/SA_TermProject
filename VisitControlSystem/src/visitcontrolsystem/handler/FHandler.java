package visitcontrolsystem.handler;

import visitcontrolsystem.model.Facility;
import visitcontrolsystem.module.VisitlistControlModule;

public class FHandler {

    private VisitlistControlModule visitlistControlModule;

    public FHandler(VisitlistControlModule visitlistControlModule) {
        this.visitlistControlModule = visitlistControlModule;
    }

    public void createVisitlist(Facility facility) {
        visitlistControlModule.createVisitlist(facility);
    }

    public void showMessage(String message) {

    }

}
