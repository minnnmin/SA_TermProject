import lombok.Getter;

import java.util.*;

@Getter
public class Visitlist {

    public Visitlist(Facility facility) {
        this.facilityInfo = facility;
        this.visitorList = new ArrayList<Checkin>();
    }
    private Facility facilityInfo;
    private ArrayList<Checkin> visitorList;

    public void addVisitorList(Checkin checkin) {
        this.visitorList.add(checkin);
    }

}