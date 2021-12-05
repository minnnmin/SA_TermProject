public class FHandler {

    private VisitlistControlModule visitlistControlModule;

    FHandler(VisitlistControlModule visitlistControlModule) {
        this.visitlistControlModule = visitlistControlModule;
    }

    public void createVisitlist(Facility facility) {
        visitlistControlModule.createVisitlist(facility);
    }

    public void showMessage(String message) {

    }

}
