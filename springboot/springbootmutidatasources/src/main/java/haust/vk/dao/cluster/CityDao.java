package haust.vk.dao.cluster;

import haust.vk.entity.City;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CityDao {
	
	City findByName(@Param("cityName") String cityName);
}
