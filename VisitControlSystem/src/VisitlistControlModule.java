import java.time.LocalDateTime;

public class VisitlistControlModule {

    ServerConnector serverConnector = new ServerConnector();

    public void createVisitlist(Facility facility) {
        serverConnector.createVisitlist(facility);
    }

    public void addVisitorInfo(Facility facility, String visitor) {
        // String visitor --> Checkin
        Checkin checkin = new Checkin(LocalDateTime.now(), visitor);
        serverConnector.addVisitorInfo(facility, checkin);
    }
}
