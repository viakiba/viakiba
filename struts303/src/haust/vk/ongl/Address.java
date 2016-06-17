package haust.vk.ongl;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class Address {
	private String province;
	private String city;
	
	public Address(){
		super();
	}
	
	public Address(String province , String city){
		this.province=province;
		this.city=city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
