package haust.vk.province;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ProvinceCityAreaAction extends ActionSupport{
	private Bean bean;
	public Bean getBean() {
		return bean;
	}
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	
	private List<String> areaList;//区域的集合
	private List<String> cityList;//城市的集合
	public List<String> getCityList() {
		return cityList;
	}
	public List<String> getAreaList() {
		return areaList;
	}
	
	/**
	 * 根据省份获得城市
	 */
	public String findCityByProvince(){
		System.out.println("进入0");
		cityList = new ArrayList<String>();
		if("湖北".equals(bean.getProvince())){
			cityList.add("武汉");
			cityList.add("赤壁");
			System.out.println("湖北");
		}else if("湖南".equals(bean.getProvince())){
			cityList.add("郴州");
			cityList.add("张家界");
			cityList.add("浏阳");
			System.out.println("湖南");
		}else if("广东".equals(bean.getProvince())){
			cityList.add("阳江");
			cityList.add("清远");
			cityList.add("佛山");
			cityList.add("湛江");
			System.out.println("广东");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据城市获取区域 
	 */
	public String findAreaByCity() throws Exception {
		System.out.println("进入00");
		areaList = new ArrayList<String>();
		if("阳江".equals(bean.getCity())){
			areaList.add("AA");
			areaList.add("BB");
			System.out.println("阳江");
		}else if("清远".equals(bean.getCity())){
			areaList.add("CC");
			areaList.add("DD");
			System.out.println("清远");
		}else if("佛山".equals(bean.getCity())){
			areaList.add("EE");
			areaList.add("FF");
			System.out.println("佛山");
		}else if("湛江".equals(bean.getCity())){
			areaList.add("GG");
			areaList.add("HH");
			System.out.println("湛江");
		}
		return SUCCESS;
	}
}
