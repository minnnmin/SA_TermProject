package Pipe_Filter;
import java.util.ArrayList;
import java.util.List;
public class DecryptFilter implements Filter {
   public Object execute (Object request) {
	   
	  // Visitor String to Visitor
//      System.out.println ( "Decrypted :" + request);
//      return request + "01234";
	   List <String> reqarray = (ArrayList)request;
	   List <Visitor> visitarr = new ArrayList<Visitor>();
	   for (int i = 0; i < reqarray.size(); i++) {
		   String[] varray = (reqarray.get(i)).split(",");
		   Visitor v = new Visitor(Long.parseLong(varray[0]), varray[1], Integer.parseInt(varray[2]),
				   varray[3], varray[4], Vaccination.valueOf(varray[5]));
		   visitarr.add(v);
	   }
	   return visitarr;
   }
}