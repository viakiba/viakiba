package haust.viakiba.sucai.entity;
      
public class BlogJava {
	private String  title ;
	private String  link ;
	private String  author ;
	private String  pubDate ;
	private String  description ;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BlogJava [title=" + title + ", link=" + link + ", author="
				+ author + ", pubDate=" + pubDate + ", description="
				+ description + "]";
	}
}
