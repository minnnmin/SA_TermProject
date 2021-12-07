package Pipe_Filter;
import java.util.ArrayList;
import java.util.List;

public class HMessage {

    public HMessage() {
    }
    
    public HMessage(List <Facility> facilities, List <String> visitors) {
    	this.facilities = new ArrayList <Facility> (facilities);
    	this.visitors = new ArrayList <String> (visitors);
    }

    private String targetContact;
    private String content;
    
    // Message 
    // Facility ArrayList
    // Visitor ArrayList(Encrypted)
    //
    
    private List <Facility> facilities;
    private List <String> visitors;
    public List <Facility> getFacilities() {
    	return this.facilities;
    }
    public List <String> getVisitors() {
    	return this.visitors;
    }

}