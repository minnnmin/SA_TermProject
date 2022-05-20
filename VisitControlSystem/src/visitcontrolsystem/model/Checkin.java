package visitcontrolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Checkin {

    private String visitedTime;
    private int visitorId;
    private String visitor;
}
