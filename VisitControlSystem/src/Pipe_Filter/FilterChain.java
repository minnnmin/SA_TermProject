package Pipe_Filter;
import java.util.ArrayList;
import java.util.List;

public class FilterChain {
   private List <Filter> filters = new ArrayList <Filter> ();
   private Target target;

   public void addFilter (Filter filter) {
      filters.add (filter);
   }

   public void execute (Object request) {
	  Object obj_req = request;
      for (Filter filter: filters) {
         obj_req = filter.execute(obj_req);
      }
      target.execute(obj_req);
   }

   public void setTarget (Target target) {
      this.target = target;
   }
}