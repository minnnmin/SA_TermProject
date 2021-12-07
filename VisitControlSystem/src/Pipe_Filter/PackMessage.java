package Pipe_Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackMessage {
	
	public PackMessage(Object obj, String content) {
    	this.obj = obj;
    	this.content = content;
    }
	private Object obj;
	private String content;
	
	public void printPackMessage() {
		if (obj.getClass() == Visitor.class) {			
			System.out.println("Visitor : " + ((Visitor)obj).getid() + "Content :" + this.content);									
		}
		else if (obj.getClass() == Facility.class) {
			System.out.println("Facility : " + ((Facility)obj).getid() + "Content :" + this.content);						
		}
		else {
			System.out.println("error");
		}		
	}
}
