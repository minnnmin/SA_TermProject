package visitcontrolsystem.connector;

import visitcontrolsystem.model.Checkin;
import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.Visitor;
import visitcontrolsystem.server.ManagementServer;
import java.util.ArrayList;

public class ServerConnector {

    private ManagementServer managementServer;

    public void connectServer(ManagementServer managementServer) {
        this.managementServer = managementServer;
    }

    // 명부 생성
    public void createVisitlist(Facility facility) {
        managementServer.createVisitlist(facility);
    }

    // 명부 기록 (갱신)
    public void addVisitorInfo(Facility facility, Checkin checkin) {
        managementServer.addVisitorInfo(facility, checkin);
    }

    // Test 용
    public void printVisitorsOf(Facility facility) {
        managementServer.printVisitorsOf(facility);
    }


    public ArrayList<Facility> searchFacilityList(Visitor visitor, String starttime, String endtime) {
        return managementServer.searchFacilityList(visitor, starttime, endtime);
    }

    public ArrayList<String> searchVisitorList(Facility facility, String starttime, String endtime) {
        return managementServer.searchVisitorList(facility, starttime, endtime);
    }
}
