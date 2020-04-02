package haust.viakiba.weather.daily.entity;

import java.util.List;
import java.util.Date;

public class Results {

    private Location location;
    private List<Daily> daily;
    private Date lastUpdate;
    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setDaily(List<Daily> daily) {
         this.daily = daily;
     }
     public List<Daily> getDaily() {
         return daily;
     }

    public void setLastUpdate(Date lastUpdate) {
         this.lastUpdate = lastUpdate;
     }
     public Date getLastUpdate() {
         return lastUpdate;
     }

}