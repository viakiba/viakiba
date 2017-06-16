package com.tdvm.common.dao;

import java.io.Serializable;
import java.util.List;

import com.tdvm.bean.PageInfo;

public interface CommonDao {
	
	public List<?> getListAndCountBySQL(final String sqlName,final Object[] values, final PageInfo pageBean, String whereSql);

	/**
	* 将一个新的对象持久到数据�?
	* @param entity
	* @return 持久化后的对�?有主键�?
	*/
	public Object create(Object entity);

	/**
	 * 从数据库删除对象o,该对象需要是persistent(持久�?状�?�?
	 * @param entity
	 */
	public void delete(Object entity);

	/**
	 * 更新对象entity,该对象需要是persistent(持久�?状�?�?
	 * @param entity
	 */
	public void update(Object entity);

	/**
	 * 根据ID查找对象
	 * @param c 返回对象的Class
	 * @param id 
	 * @return 从数据库找到的域对象
	 */
	public Object getObjectById(final Class<?> c, final Serializable id);

	/**
	 * 根据HQL获得�?��对象
	 * @param select
	 * @param values
	 * @return 
	 */
	public Object getObjectByHQL(final String select, final Object[] values, final PageInfo pageInfo);

	/**
	 * 根据HQL获得�?��对象(支持查询缓存)
	 * @param select
	 * @param values
	 * @return 
	 */
	public Object getObjectByHQLAsCache(final String select, final Object[] values, final PageInfo pageInfo);

	/**
	 * 根据SQL语句获得�?��数组对象
	 * @param select
	 * @param values
	 * @param c
	 * @return
	 */
	public List<?> getListBySQL(final String select, final Object[] values, final Class<?> c, final PageInfo pageInfo);

	/**
	 * 根据HQL语句获取�?��数组对象
	 * @param select
	 * @param values
	 * @return
	 */
	public List<?> getListByHQL(final String select, final Object[] values, final PageInfo pageInfo);

	/**
	 * 根据HQL语句获取�?��数组对象缓存
	 * @param select
	 * @param values
	 * @param pageInfo
	 * @return
	 */
	public List<?> getListByHQLByCache(final String select, final Object[] values, final PageInfo pageInfo);
	/**
	 * 批量删除
	 * @param hsql
	 */
	public void deleteByHQL(String hsql, String value);
	public void insertBySql(final String select);
}
