package haust.vk.sort;

import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import haust.vk.fy.entity.Article1;
import haust.vk.util.LuceneUtil;

/**
 * 在默认情况下，Lucene是按照相关度得份排序的
 * @author viakiba
 *
 */
public class ArticleDao1 {
	
	/**
	 * 增加document 到 对象数据库 中
	 * @throws Exception 
	 */
	@Test
	public void add() throws Exception{
		
		//Article article = new Article(1,"培训","传智是一家it培训机构",10);
		//Article article = new Article(2,"培训","北大是一家it培训机构",20);
		//Article article = new Article(3,"培训","中大是一家华南地区it培训机构",30);
		//Article article = new Article(4,"培训","哈哈培训机构是好的培训",9);
		//Article article = new Article(5,"培训","培训培训培训培训培训培训培训培训培训培训培训培训",15);
		Article1 article = new Article1(6,"培训","培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训培训",35);
		
		Document document = LuceneUtil.javabean2document(article);
		
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), LuceneUtil.getMaxFieldLength());
		
		indexWriter.addDocument(document);
		
		indexWriter.close();
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void findAll() throws Exception{
		String keywords = "培训";
		ArrayList<Article1> list = new ArrayList<Article1>();
		
		QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(), "content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs topDocs = indexSearcher.search(query, 100);
		
		for(int i=0;i<topDocs.scoreDocs.length;i++){
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			
			float score = scoreDoc.score;
			System.out.println("score"+score);
			
			Document doc = indexSearcher.doc(no);
			
			Article1 article = (Article1) LuceneUtil.document2javabean(doc, Article1.class);
			list.add(article);
		}
		
		for(Article1 a : list){
			System.out.println(a);
		}
		
		
		
	}
}
