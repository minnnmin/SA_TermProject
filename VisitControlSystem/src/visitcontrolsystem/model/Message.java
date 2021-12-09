package visitcontrolsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Message {

    public Message() {
    }
    
    public Message(List <Facility> facilities, List <String> visitors) {
    	this.facilities = new ArrayList <Facility> (facilities);
    	this.visitors = new ArrayList <String> (visitors);
    }

    private String targetContact;
    private String content;
    
    // visitcontrolsystem.model.Message
    // visitcontrolsystem.model.Facility ArrayList
    // visitcontrolsystem.model.Visitor ArrayList(Encrpted)
    //
    
    private List <Facility> facilities;
    private List <String> visitors;
    public List <Facility> getFaclities() {
    	return this.facilities;
    }
    public List <String> getVisitors() {
    	return this.visitors;
    }

}