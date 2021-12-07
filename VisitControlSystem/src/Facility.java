import lombok.Getter;

@Getter
public class Facility {

    public Facility(String name, String address, String contact) {
        this.fid = tmpFid++;
        this.fname = name;
        this.faddress = address;
        this.fcontact = contact;
    }

    private static Integer tmpFid = 1;
    private Integer fid;
    private String fname;
    private String faddress;
    private String fcontact;
}