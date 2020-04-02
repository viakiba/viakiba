package haust.vk.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import haust.vk.dao.CityDao;
import haust.vk.entity.City;
@Repository
public class CityDaoImpl implements CityDao{
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public City findByName(String cityName) {
		SqlSession os = sqlSessionFactory.openSession();
		City selectOne = os.selectOne("findByName", cityName);
		return selectOne;
	}
	
}
