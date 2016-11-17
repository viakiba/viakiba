package haust.vk.fy.dao;

import java.util.ArrayList;
import java.util.List;

import haust.vk.fy.entity.Article;
import haust.vk.util.LuceneUtil;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

public class ArticleDao {
	
	/**
	 * 获取总记录数
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public int getAllRecord(String keyword) throws Exception{
		QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(), "content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keyword);
		
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs topDocs = indexSearcher.search(query, 2);
		
		//返回符合条件的真实总记录数，不受2的影响
		return topDocs.totalHits;
		
		//返回符合条件的总记录数，受2的影响
		//return topDocs.scoreDocs.length;
	}
	
	@Test
	public List<Article> findAll(String keywords,int start,int size) throws Exception{
		List<Article> list = new ArrayList<Article>();
		
		QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(), "content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs topDocs = indexSearcher.search(query, 100);
		
		//分页
		int middle = Math.min(start+size,topDocs.totalHits);
		
		for(int i=0;i<middle;i++){
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			Document doc = indexSearcher.doc(no);
			
			Article article =(Article) LuceneUtil.document2javabean(doc, Article.class);
			
			list.add(article);
		}
		return list;
	}
	
	//测试
	public static void main(String[] args) throws Exception {
		ArticleDao articleDao = new ArticleDao();
		
		System.out.println(articleDao.getAllRecord("培训"));
		
		System.out.println(articleDao.findAll("培训", 0, 2));
		
	}
	
	/**
	 * 添加
	 * @throws Exception
	 */
	public static void add() throws Exception{
		
	}
}
