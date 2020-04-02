package haust.vk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haust.vk.dao.CityDao;
import haust.vk.entity.City;
import haust.vk.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	@Autowired
	private CityDao cityDao;
	
	@Override
	public City findCityByName(String cityName) {
		City findByName = cityDao.findByName(cityName);
		return findByName;
	}
	
}
