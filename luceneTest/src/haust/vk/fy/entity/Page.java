package haust.vk.fy.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private Integer currPageNO;//当前页号OK
	private Integer perPageSize = 2;//每页显示记录数，默认为2条OK
	private Integer allRecordNO;//总记录数OK
	private Integer allPageNO;//总页数OK
	private List<Article> articleList = new ArrayList<Article>();//内容OK
	public Page(){}
	
	public Page(Integer currPageNO, Integer perPageSize, Integer allRecordNO,
			Integer allPageNO, List<Article> articleList) {
		super();
		this.currPageNO = currPageNO;
		this.perPageSize = perPageSize;
		this.allRecordNO = allRecordNO;
		this.allPageNO = allPageNO;
		this.articleList = articleList;
	}

	public Integer getCurrPageNO() {
		return currPageNO;
	}

	public void setCurrPageNO(Integer currPageNO) {
		this.currPageNO = currPageNO;
	}

	public Integer getPerPageSize() {
		return perPageSize;
	}

	public void setPerPageSize(Integer perPageSize) {
		this.perPageSize = perPageSize;
	}

	public Integer getAllRecordNO() {
		return allRecordNO;
	}

	public void setAllRecordNO(Integer allRecordNO) {
		this.allRecordNO = allRecordNO;
	}

	public Integer getAllPageNO() {
		return allPageNO;
	}

	public void setAllPageNO(Integer allPageNO) {
		this.allPageNO = allPageNO;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	@Override
	public String toString() {
		return "Page [currPageNO=" + currPageNO + ", perPageSize="
				+ perPageSize + ", allRecordNO=" + allRecordNO + ", allPageNO="
				+ allPageNO + ", articleList=" + articleList + "]";
	}
}
