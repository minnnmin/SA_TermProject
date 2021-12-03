import java.time.LocalDateTime;

public class ServerConnector {

    ManagementServer managementServer = new ManagementServer();

    public void createVisitlist(Facility facility) {
        managementServer.createVisitlist(facility);
    }

    public void addVisitorInfo(Facility facility, Checkin checkin) {
        addVisitorInfo(facility, checkin);
    }

    public void searchFacilityList(String visitor, LocalDateTime starttime, LocalDateTime endtime) {
        managementServer.searchFacilityList(visitor, starttime, endtime);
    }

    public void searchVisitorList(Facility facility, LocalDateTime starttime, LocalDateTime endtime) {
        managementServer.searchVisitorList(facility, starttime, endtime);
    }
}
