package visitcontrolsystem.pipefilter;

public class FilterRunner {
   FilterManager filterManager;

   public void setFilterManager (FilterManager filterManager) {
      this.filterManager = filterManager;
   }

   public void sendRequest (Object request) {
      filterManager.filterRequest (request);
   }
}