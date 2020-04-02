package haust.viakiba.weather.now.entity;

import java.util.List;
public class NowRoot {
	private List<Results> results ;
	
	public void setResults(List<Results> results){
	this.results = results;
	}
	public List<Results> getResults(){
	return this.results;
	}
}
