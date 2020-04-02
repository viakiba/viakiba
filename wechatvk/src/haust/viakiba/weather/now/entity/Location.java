package haust.viakiba.weather.now.entity;

public class Location {
	private String id;

	private String name;

	private String country;

	private String path;

	private String timezone;

	private String timezone_offset;

	public void setId(String id){
	this.id = id;
	}
	public String getId(){
	return this.id;
	}
	public void setName(String name){
	this.name = name;
	}
	public String getName(){
	return this.name;
	}
	public void setCountry(String country){
	this.country = country;
	}
	public String getCountry(){
	return this.country;
	}
	public void setPath(String path){
	this.path = path;
	}
	public String getPath(){
	return this.path;
	}
	public void setTimezone(String timezone){
	this.timezone = timezone;
	}
	public String getTimezone(){
	return this.timezone;
	}
	public void setTimezone_offset(String timezone_offset){
	this.timezone_offset = timezone_offset;
	}
	public String getTimezone_offset(){
	return this.timezone_offset;
	}
}
