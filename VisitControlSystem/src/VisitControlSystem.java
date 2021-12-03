import java.time.LocalDateTime;

public class VisitControlSystem {
    public static void main(String[] args) {
        Facility f1 = new Facility("cafe1", "서울", "1234");
        Facility f2 = new Facility("cafe2", "제주", "5678");
        Facility f3 = new Facility("cafe3", "강릉", "3456");
        Visitor v1 = new Visitor("minnmin", 24, "제주", "1111", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v2 = new Visitor("JeonK1", 25, "서울", "2222", Vaccination.SECOND_VACCINATION_COMPLETED);
        Visitor v3 = new Visitor("MOLOZISE ", 26, "부산", "3333", Vaccination.SECOND_VACCINATION_COMPLETED);


    }
}
