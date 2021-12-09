package visitcontrolsystem.module;

import visitcontrolsystem.connector.ServerConnector;
import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.Visitor;

import java.util.ArrayList;

public class SearchProcessModule {

    private ServerConnector serverConnector;

    public SearchProcessModule(ServerConnector serverConnector) {
        this.serverConnector = serverConnector;
    }

    public ArrayList<Facility> searchFacilityList(Visitor visitor, String starttime, String endtime) {
        return serverConnector.searchFacilityList(visitor, starttime, endtime);
    }

    public ArrayList<String> searchVisitorList(Facility facility, String starttime, String endtime) {
        return serverConnector.searchVisitorList(facility, starttime, endtime);
    }
}
