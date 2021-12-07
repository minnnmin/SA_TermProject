import java.time.LocalDateTime;
import java.util.ArrayList;

public class SearchProcessModule {

    private ServerConnector serverConnector;

    SearchProcessModule(ServerConnector serverConnector) {
        this.serverConnector = serverConnector;
    }

    public ArrayList<Facility> searchFacilityList(Visitor visitor, String starttime, String endtime) {
        return serverConnector.searchFacilityList(visitor, starttime, endtime);
    }

    public ArrayList<Visitor> searchVisitorList(Facility facility, String starttime, String endtime) {
        return serverConnector.searchVisitorList(facility, starttime, endtime);
    }
}
