package haust.vk.fy.entity;

public class Article1 {
	private Integer id;//编号
	private String title;//标题
	private String content;//内容
	private Integer count;//字数
	
	//使用反射实例化对象  需要设置无参构造器？
	public Article1(){}
	
	public Article1(Integer id, String title, String content, Integer count) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", count=" + count + "]";
	}
}
