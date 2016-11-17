package haust.vk.fy.service;

import java.util.List;

import haust.vk.fy.dao.ArticleDao;
import haust.vk.fy.entity.Article;
import haust.vk.fy.entity.Page;

public class ArticleService {
	private ArticleDao articleDao = new ArticleDao();
	//持久层
	public Page show(String keywords,int currPageNO) throws Exception {
		Page page = new Page();
		
		//封装当前页号
		page.setCurrPageNO(currPageNO);
		
		//封装总记录数
		int allRecord = articleDao.getAllRecord(keywords);
		page.setAllRecordNO(allRecord);
		
		//封装总页数
		int allPageNO = 0;
		if(page.getAllRecordNO() % page.getPerPageSize() == 0){
			allPageNO = page.getAllRecordNO() / page.getPerPageSize();
		}else{
			allPageNO = page.getAllRecordNO() / page.getPerPageSize() + 1;
		}
		page.setAllPageNO(allPageNO);
		
		//
		int size = page.getPerPageSize();
		
		int start = (page.getCurrPageNO()-1)*size;
		
		List<Article> list = articleDao.findAll(keywords, start, size);
		
		page.setArticleList(list);
		
		return page;
	}
	
	//测试
	public static void main(String[] args) throws Exception {
		ArticleService test = new ArticleService();
		Page page = test.show("培训",1);
		
		System.out.println(page.getCurrPageNO());
		System.out.println(page.getPerPageSize());
		System.out.println(page.getAllRecordNO());
		System.out.println(page.getAllPageNO());
		for(Article a : page.getArticleList()){
			System.out.println(a);
		}
	}
}
