package haust.vk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import haust.vk.entity.City;
import haust.vk.service.CityService;

//注册为 Dubbo 服务
@Service(version="1.0.0")
public class CityServiceImpl implements CityService{

	@Override
	public City findCityByName(String cityName) {
		return new City(1L,2L,"温岭","是我的故乡");
	}

}
