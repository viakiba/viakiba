package haust.vk.dao;

import haust.vk.entity.City;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CityDao {
	List<City> findAllCity();
	
	City findById(@Param("id") Long id);
	
	Long saveCity(City city);
	
	Long updateCity(City city);
	
	Long deleteCity(Long id);
}
