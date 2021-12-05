import java.time.LocalDateTime;
import java.util.ArrayList;

public class HHandler {

    private SearchProcessModule searchProcessModule;

    HHandler(SearchProcessModule searchProcessModule) {
        this.searchProcessModule = searchProcessModule;
    }

    public void sendMessage(String message) {
        // TODO implement here
    }


    public ArrayList<Facility> searchFacilityList(Visitor visitor, String startTime, String endTime) {
        return searchProcessModule.searchFacilityList(visitor, startTime, endTime);
    }

    public ArrayList<Visitor> searchVisitorList(Facility facility, String startTime, String endTime) {
        return searchProcessModule.searchVisitorList(facility, startTime, endTime);
    }
}
