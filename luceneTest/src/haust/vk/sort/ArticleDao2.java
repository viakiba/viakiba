package haust.vk.sort;

import java.util.ArrayList;
import java.util.List;

import haust.vk.fy.entity.Article1;
import haust.vk.util.LuceneUtil;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldDocs;
import org.junit.Test;


/**
 * 演示Lucene中，根据单个或多个字段排序
 * @author viakiba
 *
 */
public class ArticleDao2 {
	
	@Test
	public void add() throws Exception{
		//Article article = new Article(1,"培训","传智是一家it培训机构",10);
		//Article article = new Article(2,"培训","北大是一家it培训机构",20);
		//Article article = new Article(3,"培训","中大是一家it培训机构",20);
		Article1 article = new Article1(7,"培训","小大是一家it培训机构",30);

		Document doc = LuceneUtil.javabean2document(article);
		
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(),LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(doc);
		
		indexWriter.close();
	
	}
	
	@Test
	public void findAll() throws Exception{
		String keywords = "培训";
		
		List<Article1> list = new ArrayList<Article1>();
		
		QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(), "content", LuceneUtil.getAnalyzer());
		Query parse = queryParser.parse(keywords);
		
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory()); 
		
		
		//TopDocs search = indexSearcher.search(parse, 100);
		
		//按照得分高低排序
		//创建排序对象
		//参数一：id表示依据document对象中的哪个字段排序，例如：id
		//参数二：SortField.INT表示document对象中该字段的类型，以常量方式书写
		//参数三：true表示降序，类似于order by id desc
		//参数三：false表示升序，类似于order by id asc
		//Sort sort = new Sort(new SortField("id",SortField.INT,false));
			
		Sort sort = new Sort(
				new SortField("count", SortField.INT,true),
				new SortField("id", SortField.INT,false)
				);
		//按count字段的降序排列，如果count字段相同的话，再按id的升序排序
				
		TopDocs search = indexSearcher.search(parse, null,100,sort);
		
		for(int i=0 ; i < search.scoreDocs.length;i++){
			ScoreDoc scoreDoc = search.scoreDocs[i];
			int no = scoreDoc.doc;
			Document doc = indexSearcher.doc(no);
			Article1 article =(Article1) LuceneUtil.document2javabean(doc, Article1.class);
			list.add(article);
		}
		
		for(Article1 a : list){
			System.out.println(a);
		}
		
		
	}
	
	
}
