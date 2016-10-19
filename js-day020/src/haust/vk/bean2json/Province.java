package haust.vk.bean2json;

import java.util.ArrayList;
import java.util.List;

public class Province {
	private Integer id;
	private String name;
	
	private List<City> cityList = new ArrayList<City>();
	public Province(){}
	
	public Province(Integer id,String name,List<City> cityList){
		this.id = id;
		this.name = name;
		this.cityList = cityList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	
}
