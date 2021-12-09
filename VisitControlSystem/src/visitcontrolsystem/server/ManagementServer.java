package visitcontrolsystem.server;

import lombok.Getter;
import visitcontrolsystem.model.Checkin;
import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.Visitlist;
import visitcontrolsystem.model.Visitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ManagementServer {

    private HashMap<String, Visitlist> visitListRepository = new HashMap(); // (key: fname, value: 시설의 명부)

    public void createVisitlist(Facility facility) {
        // 명부 하나 만들어서 시설 정보 넣고, repo에 저장
        Visitlist visitlist = new Visitlist(facility);
        visitListRepository.put(facility.getFname(), visitlist);
    }

    public void addVisitorInfo(Facility facility, Checkin checkin) {
        Visitlist visitlist = visitListRepository.get(facility.getFname());
        if (visitlist != null) {
            visitlist.addVisitorList(checkin);
            visitListRepository.put(facility.getFname(), visitlist);
        } else {
            System.out.println("해당 시설의 명부는 개설되지 않았습니다.");
        }
    }

    // Test 용 - 명부 개설 및 방문기록 추가 테스트
    public void printVisitorsOf(Facility facility) {
        Visitlist visitlist = visitListRepository.get(facility.getFname());
        if (visitlist != null) {
            visitlist.printVisitlist();
        } else {
            System.out.println(facility.getFname() + "의 명부는 개설되지 않았거나 비어있습니다.");
        }
    }


    public ArrayList<Facility> searchFacilityList(Visitor visitor, String starttime, String endtime) {
        ArrayList<Facility> facilityList = new ArrayList<>();
        for (Map.Entry<String, Visitlist> f : visitListRepository.entrySet()) {
            Visitlist visitlist = f.getValue();
            for (Checkin checkin : visitlist.getVisitorList()) {
                if (checkin.getVisitorId() == visitor.getVid()) {
                    if (Long.parseLong(starttime) <= Long.parseLong(checkin.getVisitedTime()) && Long.parseLong(checkin.getVisitedTime()) <= Long.parseLong(endtime)) {
                        facilityList.add(visitlist.getFacilityInfo());
                    }
                }
            }
        }
        return facilityList;
    }

    public ArrayList<String> searchVisitorList(Facility facility, String starttime, String endtime) {
        // 해당 기간동안 해당 시설에 방문한 사람들 리스트로 출력
        ArrayList<String> visitorList = new ArrayList<>();
        Visitlist visitlist = visitListRepository.get(facility.getFname());
        for (Checkin checkin : visitlist.getVisitorList()) {
            if (Long.parseLong(starttime) <= Long.parseLong(checkin.getVisitedTime()) && Long.parseLong(checkin.getVisitedTime()) <= Long.parseLong(endtime)) {
                visitorList.add(checkin.getVisitor());
            }
        }
        return visitorList;
    }
}
