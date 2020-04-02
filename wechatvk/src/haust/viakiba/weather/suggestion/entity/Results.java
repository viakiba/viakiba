package haust.viakiba.weather.suggestion.entity;

import java.util.Date;

public class Results {
	private Location location;
    private Suggestion suggestion;
    private Date lastUpdate;
    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setSuggestion(Suggestion suggestion) {
         this.suggestion = suggestion;
     }
     public Suggestion getSuggestion() {
         return suggestion;
     }

    public void setLastUpdate(Date lastUpdate) {
         this.lastUpdate = lastUpdate;
     }
     public Date getLastUpdate() {
         return lastUpdate;
     }
}


