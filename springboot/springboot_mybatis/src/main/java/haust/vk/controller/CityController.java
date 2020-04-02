package haust.vk.controller;

import haust.vk.entity.City;
import haust.vk.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/city")
	public City haha(){
		System.out.println("haha");
		City findCityByName = cityService.findCityByName("dsa");
		return findCityByName;
	}
}
