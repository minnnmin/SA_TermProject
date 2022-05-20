package visitcontrolsystem.module;

import visitcontrolsystem.connector.ServerConnector;
import visitcontrolsystem.model.Checkin;
import visitcontrolsystem.model.Facility;

public class VisitlistControlModule {

    private ServerConnector serverConnector;

    public VisitlistControlModule(ServerConnector serverConnector) {
        this.serverConnector = serverConnector;
    }

    public void createVisitlist(Facility facility) {
        serverConnector.createVisitlist(facility);
    }

    public void addVisitorInfo(Facility facility, int visitorId, String visitorEnc, String visitedTime) {
        Checkin checkin = new Checkin(visitedTime, visitorId, visitorEnc);
        serverConnector.addVisitorInfo(facility, checkin);
    }

    // Test 용
    public void printVisitorsOf(Facility facility) {
        serverConnector.printVisitorsOf(facility);
    }
}
