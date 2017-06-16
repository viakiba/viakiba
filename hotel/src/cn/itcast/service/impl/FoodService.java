package cn.itcast.service.impl;

import cn.itcast.dao.IFoodDao;
import cn.itcast.entity.Food;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodService;
import cn.itcast.utils.PageBean;

public class FoodService implements IFoodService {

	// ´´½¨dao
	private IFoodDao foodDao = BeanFactory.getInstance("foodDao", IFoodDao.class);
	
	@Override
	public Food findById(int id) {
		try {
			return foodDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void getAll(PageBean<Food> pb) {
		try {
			foodDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
