package haust.vk.bean2json;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;

public class TestDemo {
	public static void javabean2json(){
		City city = new City(1,"广州");
		JSONArray str = JSONArray.fromObject(city);
		String json = str.toString();
		System.out.println(json);
	}
	
	public static void list2json(){
		City city1 = new City(1,"广州");
		City city2 = new City(2,"大声道");
		City city3 = new City(3,"广阿达");
		List<City> list = new ArrayList<City>();
		list.add(city1);
		list.add(city2);
		list.add(city3);
		
		JSONArray lit = JSONArray.fromObject(list);
		String str = lit.toString();
		System.out.println(str);
		
	}
	
	public static void set2json(){
		Set<City> set = new LinkedHashSet<City>();
		set.add(new City(1,"广州"));
		set.add(new City(2,"大声道"));
		set.add(new City(3,"广阿达"));
		
		JSONArray json = JSONArray.fromObject(set);
		System.out.println(json.toString());
	}
	
	public static void main(String[] args) {
		//javabean2json();
		//list2json();
		set2json();
	}
	
}
