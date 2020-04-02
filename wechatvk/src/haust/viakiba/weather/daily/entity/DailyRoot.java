package haust.viakiba.weather.daily.entity;
import java.util.List;
public class DailyRoot {

    private List<Results> results;
    public void setResults(List<Results> results) {
         this.results = results;
     }
     public List<Results> getResults() {
         return results;
     }

}