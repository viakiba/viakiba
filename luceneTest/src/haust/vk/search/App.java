package haust.vk.search;

import java.util.ArrayList;

import haust.vk.entity.Article;
import haust.vk.util.LuceneUtil;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

/**
 * 
 * 演示lucene中，根据多个字段搜索
 * @author viakiba
 *
 */
public class App {
	
	/**
	 * 增加document对象索引库中
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception{
		Article article = new Article(1,"培训","传智是一家it培训机构",10);
		//Article article = new Article(2,"培训","北大是一家it培训机构",20);
		//Article article = new Article(3,"培训","中大是一家it培训机构",20);
		//Article article = new Article(4,"培训","小大是一家it培训机构",30);
		Document document = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory()	,LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(document);
		indexWriter.close();
	}
	
	/**
	 * 搜索
	 * @throws Exception
	 */
	@Test
	public void findAll() throws Exception{
		String keywords = "北大";
		ArrayList<Article> list = new ArrayList<Article>();
		
		//单字段搜索
		//QueryParser query = new QueryParser(LuceneUtil.getVersion(), "title", LuceneUtil.getAnalyzer());
		
		MultiFieldQueryParser query = new MultiFieldQueryParser(LuceneUtil.getVersion(), new String[]{"content","title"}, LuceneUtil.getAnalyzer());
		
		Query parse = query.parse(keywords);
		
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs search = indexSearcher.search(parse, 100);
		
		for(int i=0;i<search.scoreDocs.length;i++){
			ScoreDoc scoreDoc = search.scoreDocs[i];
			int doc = scoreDoc.doc;
			Document doc2 = indexSearcher.doc(doc);
			Article article = (Article) LuceneUtil.document2javabean(doc2, Article.class);
			list.add(article);
		}
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
