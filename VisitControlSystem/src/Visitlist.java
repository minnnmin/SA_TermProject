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

    // Test 용
    public void printVisitlist() {
        System.out.println(facilityInfo.getFname() + "의 방문기록입니다.");
        for (Checkin checkin : visitorList) {
            System.out.print("name: " + checkin.getVisitor().getVname());
            System.out.println(", visitedTime: " + checkin.getVisitedTime());
        }
        System.out.println();
    }
}