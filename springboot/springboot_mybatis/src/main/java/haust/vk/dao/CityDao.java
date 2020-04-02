package haust.vk.dao;

import haust.vk.entity.City;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CityDao {
	public City findByName(@Param("cityName") String cityName);
}
