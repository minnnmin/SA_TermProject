package visitcontrolsystem;

import visitcontrolsystem.connector.ServerConnector;
import visitcontrolsystem.handler.CHandler;
import visitcontrolsystem.handler.FHandler;
import visitcontrolsystem.handler.HHandler;
import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.HMessage;
import visitcontrolsystem.model.Vaccination;
import visitcontrolsystem.model.Visitor;
import visitcontrolsystem.module.EncryptModule;
import visitcontrolsystem.module.NotificationControlModule;
import visitcontrolsystem.module.SearchProcessModule;
import visitcontrolsystem.module.VisitlistControlModule;
import visitcontrolsystem.server.CAServer;
import visitcontrolsystem.server.ManagementServer;
import java.util.ArrayList;
import java.util.List;

public class VisitControlSystem {
    public static void main(String[] args) {
        
        ManagementServer managementServer = new ManagementServer();
        ServerConnector serverConnector = new ServerConnector();
        serverConnector.connectServer(managementServer);

        CAServer caServer = new CAServer();
        EncryptModule encryptModule = new EncryptModule(caServer);
        VisitlistControlModule visitlistControlModule = new VisitlistControlModule(serverConnector);
        SearchProcessModule searchProcessModule = new SearchProcessModule(serverConnector);

        FHandler fHandler = new FHandler(visitlistControlModule);
        CHandler cHandler = new CHandler(visitlistControlModule,encryptModule);
        HHandler hHandler = new HHandler(searchProcessModule,encryptModule);
        
        // 시설, 고객 데이터
        Facility f1 = new Facility("cafe1", "서울", "010-1234-1234");
        Facility f2 = new Facility("cafe2", "경기", "010-2345-2345");
        Facility f3 = new Facility("cafe3", "대전", "010-3456-3456");
        Facility f4 = new Facility("cafe4", "부산", "010-4567-4567");
        Facility f5 = new Facility("cafe5", "제주", "010-5678-5678");
        Visitor v1 = new Visitor("곽민정", 12, "제주", "010-1111-1111", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v2 = new Visitor("전계원", 14, "서울", "010-2222-2222", Vaccination.UNVACCINATED);
        Visitor v3 = new Visitor("우창석", 18, "부산", "010-3333-3333", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v4 = new Visitor("이민호", 25, "대전", "010-4444-4444", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v5 = new Visitor("김준우", 35, "경기", "010-5555-5555", Vaccination.FIRST_VACCINATION_COMPLETED);
        Visitor v6 = new Visitor("최지원", 40, "서울", "010-6666-6666", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v7 = new Visitor("강승완", 45, "부산", "010-7777-7777", Vaccination.FIRST_VACCINATION_COMPLETED);
        Visitor v8 = new Visitor("정제윈", 52, "경기", "010-8888-8888", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v9 = new Visitor("이재원", 60, "서울", "010-9999-9999", Vaccination.UNVACCINATED);
        Visitor v10 = new Visitor("최지혜", 72, "부산", "010-0000-0000", Vaccination.SECOND_VACCINATION_COMPLETED);

        // 명부개설 & 방문기록 추가
        // f1에 v1 ~ v10 방문
        fHandler.createVisitlist(f1);
        cHandler.addVisitorInfo(f1, v1, "20211201");
        cHandler.addVisitorInfo(f1, v2, "20211201");
        cHandler.addVisitorInfo(f1, v3, "20211202");
        cHandler.addVisitorInfo(f1, v4, "20211202");
        cHandler.addVisitorInfo(f1, v5, "20211205");
        cHandler.addVisitorInfo(f1, v6, "20211205");
        cHandler.addVisitorInfo(f1, v7, "20211206");
        cHandler.addVisitorInfo(f1, v8, "20211206");
        cHandler.addVisitorInfo(f1, v9, "20211206");
        cHandler.addVisitorInfo(f1, v10, "20211207");

        // f2에 v1 ~ v5 방문
        fHandler.createVisitlist(f2);
        cHandler.addVisitorInfo(f2, v1, "20211211");
        cHandler.addVisitorInfo(f2, v2, "20211211");
        cHandler.addVisitorInfo(f2, v3, "20211212");
        cHandler.addVisitorInfo(f2, v4, "20211212");
        cHandler.addVisitorInfo(f2, v5, "20211214");

        // f3에 v6 ~ v10 방문
        fHandler.createVisitlist(f3);
        cHandler.addVisitorInfo(f3, v6, "20211215");
        cHandler.addVisitorInfo(f3, v7, "20211216");
        cHandler.addVisitorInfo(f3, v8, "20211216");
        cHandler.addVisitorInfo(f3, v9, "20211216");
        cHandler.addVisitorInfo(f3, v10, "20211217");

        // f4에 v1, 3, 5, 6, 7, 9 방문
        fHandler.createVisitlist(f4);
        cHandler.addVisitorInfo(f4, v1, "20211202");
        cHandler.addVisitorInfo(f4, v3, "20211208");
        cHandler.addVisitorInfo(f4, v5, "20211209");
        cHandler.addVisitorInfo(f4, v6, "20211215");
        cHandler.addVisitorInfo(f4, v7, "20211218");
        cHandler.addVisitorInfo(f4, v9, "20211220");

        // f5에 v2, 3, 4, 6, 8, 10 방문
        fHandler.createVisitlist(f4);
        cHandler.addVisitorInfo(f4, v2, "20211201");
        cHandler.addVisitorInfo(f4, v3, "20211205");
        cHandler.addVisitorInfo(f4, v4, "20211207");
        cHandler.addVisitorInfo(f4, v6, "20211215");
        cHandler.addVisitorInfo(f4, v8, "20211223");
        cHandler.addVisitorInfo(f4, v10, "20211231");


        // 특정 기간 내 확진자(v3)가 다녀간 시설 리스트
        System.out.println("[특정 기간 내 확진자가 다녀간 시설 리스트]");
        ArrayList<Facility> facilityList = hHandler.searchFacilityList(v3, "20211201", "20211212");
        if (facilityList.isEmpty()) {
            System.out.println("해당 기간 동안 확진자가 다녀간 시설이 없습니다.");
        } else {
            for (Facility facility : facilityList) {
                System.out.println(facility.getFname());
            }
        }

        // 특정 기간 내 해당 시설(f1)에 다녀간 방문자 리스트
        System.out.println("\n[특정 기간 내 해당 시설에 다녀간 방문자 리스트]");
        ArrayList<String> visitorList = hHandler.searchVisitorList(f1, "20211201", "20211208");
        if (visitorList.isEmpty()) {
            System.out.println("해당 기간 동안 시설에 다녀간 방문객이 없습니다.");
        } else {
            for (String visitorEnc : visitorList) {
                System.out.println(visitorEnc);
            }
        }

        // visitcontrolsystem.module.NotificationControlModule 테스트
        NotificationControlModule nofi = new NotificationControlModule();

        List<String> vs = new ArrayList();
        for (String visitorEnc: visitorList){
            vs.add(visitorEnc);
        }

        System.out.println("\n[우선순위 별 알림 전송]");
        HMessage hm = new HMessage(facilityList, vs);
        nofi.sendMessage(hm);
    }
}