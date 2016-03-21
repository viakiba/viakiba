package haust.vk.dao;

import haust.vk.entiry.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private static List<Product> data= new ArrayList<Product>();
	
	/*
	 * 初始化商品数据
	 */
	static {
		for(int i=0;i<=10;i++){
			data.add(new Product(""+i,"笔记本"+i,"LN00"+i,34.0+i));
		}
	}
	
	/*
	 * 搜索所有商品
	 */
	public List<Product> findAll(){
		return data;
	}
	
	/*
	 * 根据编号查询方法
	 */
	
	public Product findByid(String id){
		for(Product p:data){
			if(p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}
}
