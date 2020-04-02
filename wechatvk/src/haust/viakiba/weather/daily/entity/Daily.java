package haust.viakiba.weather.daily.entity;

import java.util.Date;

public class Daily {

    private Date date;
    private String textDay;
    private String codeDay;
    private String textNight;
    private String codeNight;
    private String high;
    private String low;
    private String precip;
    private String windDirection;
    private String windDirectionDegree;
    private String windSpeed;
    private String windScale;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setTextDay(String textDay) {
         this.textDay = textDay;
     }
     public String getTextDay() {
         return textDay;
     }

    public void setCodeDay(String codeDay) {
         this.codeDay = codeDay;
     }
     public String getCodeDay() {
         return codeDay;
     }

    public void setTextNight(String textNight) {
         this.textNight = textNight;
     }
     public String getTextNight() {
         return textNight;
     }

    public void setCodeNight(String codeNight) {
         this.codeNight = codeNight;
     }
     public String getCodeNight() {
         return codeNight;
     }

    public void setHigh(String high) {
         this.high = high;
     }
     public String getHigh() {
         return high;
     }

    public void setLow(String low) {
         this.low = low;
     }
     public String getLow() {
         return low;
     }

    public void setPrecip(String precip) {
         this.precip = precip;
     }
     public String getPrecip() {
         return precip;
     }

    public void setWindDirection(String windDirection) {
         this.windDirection = windDirection;
     }
     public String getWindDirection() {
         return windDirection;
     }

    public void setWindDirectionDegree(String windDirectionDegree) {
         this.windDirectionDegree = windDirectionDegree;
     }
     public String getWindDirectionDegree() {
         return windDirectionDegree;
     }

    public void setWindSpeed(String windSpeed) {
         this.windSpeed = windSpeed;
     }
     public String getWindSpeed() {
         return windSpeed;
     }

    public void setWindScale(String windScale) {
         this.windScale = windScale;
     }
     public String getWindScale() {
         return windScale;
     }

}