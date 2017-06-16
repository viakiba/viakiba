package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 3. 菜系模块业务逻辑层，接口设计
 * @author Jie.Yuan
 *
 */
public interface IFoodTypeService {


	/**
	 * 添加
	 */
	void save(FoodType foodType);
	
	/**
	 * 更新
	 */
	void update(FoodType foodType);
	
	/**
	 * 删除
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询
	 */
	FoodType findById(int id);
	
	/**
	 * 查询全部
	 */
	List<FoodType> getAll();
	
	/**
	 * 根据菜系名称查询
	 */
	List<FoodType> getAll(String typeName);
	
	
}









