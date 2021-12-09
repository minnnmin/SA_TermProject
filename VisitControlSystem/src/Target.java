import java.util.ArrayList;
import java.util.List;

public class Target {
   public void execute (Object request) {
	   //System.out.println ( "Final Message:" + request);
	   List<PackMessage> reqlist = (ArrayList<PackMessage>)request;
	   for (int i = 0; i < reqlist.size(); i++) {
		   reqlist.get(i).printPackMessage();
	   }
   }
}