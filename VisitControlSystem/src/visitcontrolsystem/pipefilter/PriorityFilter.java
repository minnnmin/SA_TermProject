package visitcontrolsystem.pipefilter;

import visitcontrolsystem.model.Facility;
import visitcontrolsystem.model.Visitor;
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
		// visitor 은 백신접종여부와 나이에 따라 우선순위 전송
    	Visitor v1 = (Visitor) o1;
    	Visitor v2 = (Visitor) o2;

		if(v1.getVaccination().compareTo(v2.getVaccination()) != 0){
			// 백신접종여부가 다를 경우, 작은 값이 더 앞으로 오도록 정렬
			return v1.getVaccination().compareTo(v2.getVaccination()); 
		} else {
			// 백신접종여부가 같을 경우, 나이에 따라 우선순위 정렬
			int v1AgePriority = 0;
			if(v1.getVage() >= 60){
				v1AgePriority = 1; // 60세 이상 1순위
			} else if (v1.getVage() <= 15){
				v1AgePriority = 2; // 15세 이하 2순위
			} else {
				v1AgePriority = 3; // 나머지 3순위
			}

			int v2AgePriority = 0;
			if(v2.getVage() >= 60){
				v2AgePriority = 1; // 60세 이상 1순위
			} else if (v2.getVage() <= 15){
				v2AgePriority = 2; // 15세 이하 2순위
			} else {
				v2AgePriority = 3; // 나머지 3순위
			}

			return Integer.compare(v1AgePriority, v2AgePriority);
		}
    }
}

class PriorityF implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
    	// facilty 는 id 값 우선순위로 전송
    	Facility v1 = (Facility) o1;
    	Facility v2 = (Facility) o2;
        return v1.getFid().compareTo(v2.getFid());
    }
 
}

