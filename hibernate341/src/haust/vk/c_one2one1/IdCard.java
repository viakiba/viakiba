package haust.vk.c_one2one1;

public class IdCard {
	//身份证号的主键
	private String cardNum;
	//身份证地址
	private String place;
	//身份证与用户 一对一
	private User user;
	
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
