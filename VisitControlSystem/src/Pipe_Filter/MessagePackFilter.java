package Pipe_Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessagePackFilter implements Filter {
   public Object execute(Object request) {
//      System.out.println ( "MessagePacked :" + request);
//      return request + "1112131415";
	   List<Object> reqlist = (ArrayList<Object>)request;
	   if (reqlist.get(0).getClass() == Visitor.class) {
		   List<PackMessage> pms = new ArrayList<PackMessage>();
		   for (int i = 0; i < reqlist.size(); i++) {
			   PackMessage pm = new PackMessage(reqlist.get(i), "content - Visitor alert");
			   pms.add(pm);
		   }
		   return pms; 
	   }
	   else if (reqlist.get(0).getClass() == Facility.class) {
		   List<PackMessage> pms = new ArrayList<PackMessage>();
		   for (int i = 0; i < reqlist.size(); i++) {
			   PackMessage pm = new PackMessage(reqlist.get(i), "content - Facility alert");
			   pms.add(pm);
		   }
		   return pms;
	   }
	   else {
		   System.out.println("error");
		   return null;
	   }
   }
}