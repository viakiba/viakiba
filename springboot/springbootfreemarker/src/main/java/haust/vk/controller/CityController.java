package haust.vk.controller;

import java.util.List;

import haust.vk.entity.City;
import haust.vk.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {
	
	@Autowired CityService cityService;
	
	@RequestMapping(value="/api/city/{id}",method=RequestMethod.GET)
	public String getCity(Model model,@PathVariable("id") Long id){
		model.addAttribute("city",cityService.findCityById(id));
		return "city";
	}
	
	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "cityList";
	}
}
