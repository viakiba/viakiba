package haust.vk.controller;

import java.util.List;

import haust.vk.entity.City;
import haust.vk.service.CityService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRestController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value="/api/city/{id}",method = RequestMethod.GET)
	public City findOneCity(@PathVariable("id") Long id){
		System.out.println("findCityById");
		return cityService.findCityById(id);
	}
	
	@RequestMapping(value="/api/city",method = RequestMethod.GET)
	public List<City> findAllCity(){
		System.out.println("findAllCity");
		return cityService.findAllCity();
	}
	
	@RequestMapping(value="/api/city",method = RequestMethod.POST)
	public void createCity(@RequestBody City city){
		System.out.println("createCity");
		cityService.saveCity(city);
	}
	
	@RequestMapping(value="/api/city",method = RequestMethod.PUT)
	public void modifyCity(@RequestBody City city){
		System.out.println("modifyCity");
		cityService.updateCity(city);
	}
	
	@RequestMapping(value="/api/city/{id}",method = RequestMethod.DELETE)
	public void modifyCity(@PathVariable("id") Long id){
		System.out.println("modifyCity");
		cityService.deleteCity(id);
	}
	
}
