import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;

@Getter
public class ManagementServer {

    private HashMap<Integer, Visitlist> visitListRepository = new HashMap(); // (key: fid, value: 시설의 명부)

    public void createVisitlist(Facility facility) {
        // 명부 하나 만들어서 시설 정보 넣고, repo에 저장
        Visitlist visitlist = new Visitlist(facility);
        visitListRepository.put(facility.getFid(), visitlist);
    }

    public void addVisitorInfo(Facility facility, Checkin checkin) {
        Visitlist visitlist = visitListRepository.get(facility.getFid());
        visitlist.addVisitorList(checkin);
    }

    public void searchFacilityList(String visitor, LocalDateTime starttime, LocalDateTime endtime) {
        // TODO implement here
    }

    public void searchVisitorList(Facility facility, LocalDateTime starttime, LocalDateTime endtime) {
        // TODO implement here
    }
}
