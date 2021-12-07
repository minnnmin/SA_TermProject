import java.time.LocalDateTime;

public class VisitlistControlModule {

    private ServerConnector serverConnector;

    VisitlistControlModule(ServerConnector serverConnector) {
        this.serverConnector = serverConnector;
    }

    public void createVisitlist(Facility facility) {
        serverConnector.createVisitlist(facility);
    }

    public void addVisitorInfo(Facility facility, Visitor visitor, String visitedTime) {
        Checkin checkin = new Checkin(visitedTime, visitor);
        serverConnector.addVisitorInfo(facility, checkin);
    }

    // Test 용
    public void printVisitorsOf(Facility facility) {
        serverConnector.printVisitorsOf(facility);
    }
}
