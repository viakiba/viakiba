package cn.itcast.entity;

public class Food {

	private int id;// INT PRIMARY KEY AUTO_INCREMENT, -- 主键
	private String foodName;// VARCHAR(20), -- 菜名称
	private int foodType_id;// INT, -- 所属菜系, 外键字段
	private double price;// DOUBLE, -- 价格
	private double mprice;// DOUBLE, -- 会员价格
	private String remark;// VARCHAR(200), -- 简介
	private String img;// VARCHAR(100) -- 图片
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodType_id() {
		return foodType_id;
	}
	public void setFoodType_id(int foodTypeId) {
		foodType_id = foodTypeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMprice() {
		return mprice;
	}
	public void setMprice(double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}
