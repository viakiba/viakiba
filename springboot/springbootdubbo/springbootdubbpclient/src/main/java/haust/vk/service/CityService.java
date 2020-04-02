package haust.vk.service;

import haust.vk.entity.City;

/**
 * 城市业务 Dubbo 服务层
 *
 */
public interface CityService {
	/**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}
