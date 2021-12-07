package Pipe_Filter;

public class Visitor {

    public Visitor(Long id, String name, int age, String address, String contact, Vaccination vaccination) {
        this.vid = id;
        this.vname = name;
        this.vage = age;
        this.vaddress = address;
        this.vcontact = contact;
        this.vaccination = vaccination;
    }

    private Long vid;
    private String vname;
    private int vage;
    private String vaddress;
    private String vcontact;
    private Vaccination vaccination;
    
    ////
    public Long getid() {
    	return this.vid;
    }
    ////
}