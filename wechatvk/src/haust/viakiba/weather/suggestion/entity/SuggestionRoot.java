package haust.viakiba.weather.suggestion.entity;
import java.util.List;

public class SuggestionRoot {
	private List<Results> results;
    public void setResults(List<Results> results) {
         this.results = results;
     }
     public List<Results> getResults() {
         return results;
     }
}
