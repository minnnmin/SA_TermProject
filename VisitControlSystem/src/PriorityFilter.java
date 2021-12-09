import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PriorityFilter implements Filter {
   public Object execute (Object request) {
//      System.out.println ( "Priority request:" + request);
//      return request + "56789";
	   List<Object> reqlist = (ArrayList<Object>)request;
	   if (reqlist.get(0).getClass() == Visitor.class) {		   
		   PriorityV pv = new PriorityV();		   
	       Collections.sort(reqlist, pv);
		   return reqlist; 
	   }
	   else if (reqlist.get(0).getClass() == Facility.class) {
		   PriorityF pf = new PriorityF();
		   Collections.sort(reqlist, pf);
		   return reqlist;
	   }
	   else {
		   System.out.println("error");
		   return null;
	   }
   }
}

class PriorityV implements Comparator<Object> {
	 
    @Override
    public int compare(Object o1, Object o2) {
    	Visitor v1 = (Visitor) o1;
    	Visitor v2 = (Visitor) o2;
        return v1.getVid().compareTo(v2.getVid());
    }
 
}

class PriorityF implements Comparator<Object> {
	 
    @Override
    public int compare(Object o1, Object o2) {
    	Facility v1 = (Facility) o1;
    	Facility v2 = (Facility) o2;
        return v1.getFid().compareTo(v2.getFid());
    }
 
}

