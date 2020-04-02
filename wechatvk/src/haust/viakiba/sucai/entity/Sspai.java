package haust.viakiba.sucai.entity;
    
public class Sspai {
	private String title;
	private String creator;
	private String link;
	private String description;
	private String pubDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
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
	@Override
	public String toString() {
		return "Sspai [title=" + title + ", creator=" + creator + ", link="
				+ link + ", description=" + description + ", pubDate="
				+ pubDate + "]";
	}
}
