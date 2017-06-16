package cn.itcast.utils;

/**
 * 封装条件
 * 
 * @author Jie.Yuan
 * 
 */
public class Condition {

	// 菜的类别作为条件
	private int foodTypeId;
	// 才的名称作为条件
	private String foodName;
	public int getFoodTypeId() {
		return foodTypeId;
	}
	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	
}
