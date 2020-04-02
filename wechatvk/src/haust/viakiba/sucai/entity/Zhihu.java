package haust.viakiba.sucai.entity;

public class Zhihu {
	
	private String title;//标题
	private String link; //链接
	private String description;//详情
	private String pubDate;//时间 收录
	private String guid;//导航
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	@Override
	public String toString() {
		return "Zhihu [title=" + title + ", link=" + link + ", description="
				+ description + ", pubDate=" + pubDate + ", guid=" + guid + "]";
	}
}
