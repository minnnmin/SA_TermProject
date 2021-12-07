import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Checkin {

    private String visitedTime;
    private Visitor visitor;
//    private String visitor;
}