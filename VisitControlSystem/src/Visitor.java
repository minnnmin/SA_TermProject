import lombok.Getter;

@Getter
public class Visitor {

    public Visitor(String name, int age, String address, String contact, Vaccination vaccination) {
        this.vid = tmpVid++;
        this.vname = name;
        this.vage = age;
        this.vaddress = address;
        this.vcontact = contact;
        this.vaccination = vaccination;
    }

    public Visitor(Integer vid, String name, int age, String address, String contact, Vaccination vaccination) {
        this.vid = vid;
        this.vname = name;
        this.vage = age;
        this.vaddress = address;
        this.vcontact = contact;
        this.vaccination = vaccination;
    }

    private static Integer tmpVid = 1;
    private Integer vid;
    private String vname;
    private int vage;
    private String vaddress;
    private String vcontact;
    private Vaccination vaccination;
}
