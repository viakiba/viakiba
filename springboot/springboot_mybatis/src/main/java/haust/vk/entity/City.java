package haust.vk.entity;

public class City {
	private String id;
	private String provinceId;
	private String cityName;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", provinceId=" + provinceId + ", cityName="
				+ cityName + ", description=" + description + "]";
	}
}
