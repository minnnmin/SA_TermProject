package visitcontrolsystem.module;

import visitcontrolsystem.model.HMessage;
import visitcontrolsystem.pipefilter.*;

public class NotificationControlModule {

    private FilterManager FacilityManager;
    private FilterManager VisitorManager;
    private FilterRunner FacilityR;
    private FilterRunner VisitorR;

    public NotificationControlModule() {
        // Filter가 있다면
        this.FacilityManager = new FilterManager(new Target());
        FacilityManager.setFilter(new PriorityFilter());
        FacilityManager.setFilter(new MessagePackFilter());
        this.FacilityR = new FilterRunner();
        FacilityR.setFilterManager (FacilityManager);

        this.VisitorManager = new FilterManager(new Target());
        VisitorManager.setFilter(new DecryptFilter());
        VisitorManager.setFilter(new PriorityFilter());
        VisitorManager.setFilter(new MessagePackFilter());
        this.VisitorR = new FilterRunner();
        VisitorR.setFilterManager(VisitorManager);
    }
    // Priority Filter는 visitcontrolsystem.model.Facility ArrayList를 받고 이에 대한 priority 계산 후 정렬 후 return

    public void sendMessage(HMessage message) {
        this.FacilityR.sendRequest (message.getFacilities()); // 인자로 message의 visitcontrolsystem.model.Facility ArrayList를 넘길 것
        this.VisitorR.sendRequest(message.getVisitors()); // 인자로 message의 visitcontrolsystem.model.Visitor(String) ArrayList를 넘길 것
    }
}
