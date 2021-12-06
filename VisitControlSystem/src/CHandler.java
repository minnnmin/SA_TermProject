public class CHandler {

    private VisitlistControlModule visitlistControlModule;

    CHandler(VisitlistControlModule visitlistControlModule) {
        this.visitlistControlModule = visitlistControlModule;
    }
    public void addVisitorInfo(Facility facility, Visitor visitor, String visitedTime) {
        visitlistControlModule.addVisitorInfo(facility, visitor, visitedTime);
    }

    // Test 용
    public void printVisitorsOf(Facility facility) {
        visitlistControlModule.printVisitorsOf(facility);
    }


    public void showMessage(String message) {
        // TODO implement here
    }
}
