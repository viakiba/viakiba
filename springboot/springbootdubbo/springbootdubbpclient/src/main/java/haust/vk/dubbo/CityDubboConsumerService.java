package haust.vk.dubbo;

import haust.vk.entity.City;
import haust.vk.service.CityService;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class CityDubboConsumerService {
	 @Reference(version = "1.0.0")
	 CityService cityService;
	 
	 public void printCity() {
	        String cityName="温岭";
	        City city = cityService.findCityByName(cityName);
	        System.out.println(city.toString());
	   }
}
