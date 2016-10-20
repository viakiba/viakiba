package haust.vk.provincecity;

import java.util.LinkedHashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

public class ProvinceCityAction extends ActionSupport{
	private String province;
	public void setProvince(String province) {
		this.province = province;
		//System.out.println("注入" + province);
	}
	//根据省份查询城市
	public String findCityByProvince() throws Exception {
		setCity = new LinkedHashSet<String>();
		if("湖南".equals(province)){
			setCity.add("长沙");
			setCity.add("株洲");
		}else if("广东".equals(province)){
			setCity.add("广州");
			setCity.add("中山");
			setCity.add("佛山");
		}
		return SUCCESS;
	}
	private Set<String> setCity;
	public Set<String> getSetCity() {
		return setCity;
	}
	
}
