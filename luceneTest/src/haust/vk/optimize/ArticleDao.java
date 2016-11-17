package haust.vk.optimize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import haust.vk.entity.Article;
import haust.vk.util.LuceneUtil;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

/**
 * 索引库优化
 * @author viakiba
 *
 */
public class ArticleDao {
	
	/**
	 * 增加document到对象
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception{
		Article article = new Article(8,"培训","黄鹏睡觉哦",10);
		Document d = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(d);
		indexWriter.close();
	}
	
	/**
	 * 合并cfs文件，合并后的cfs文件是二进制压缩字符，能解决是的文件大小和数量的问题
	 * @throws Exception
	 */
	@Test
	public void type1() throws Exception{
		Article article = new Article(8,"培训","黄鹏睡觉哦",10);
		Document d = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(d);
		indexWriter.optimize();
		
		indexWriter.close();
	}
	
	/**
	 * 设定合并因子，自动合并cfs文件
	 * @throws Exception
	 */
	public void type2() throws Exception{
		Article article = new Article(1,"培训","传智是一家it培训机构123234",10);
		Document d = LuceneUtil.javabean2document(article);
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), LuceneUtil.getMaxFieldLength());
		indexWriter.addDocument(d);
		//设置合并因子，即满足3个cfs文本一合并
		indexWriter.setMergeFactor(3);
		indexWriter.close();
	}
	
	/**
	 * 使用RAMDirectory，类似于内存索引库，能解决是的读取索引库文件的速度问题
	 * @throws Exception
	 */
	public void type3() throws Exception{
		Article article = new Article(1,"培训","传智是一家it培训机构123234",10);
		Document d = LuceneUtil.javabean2document(article);
		
		//硬盘索引库
		FSDirectory fsdic = FSDirectory.open(new File("C:/luce"));
		
		//内存索引库，因为硬盘索引库的内容要同步到内存索引库中
		RAMDirectory ramDirectory = new RAMDirectory(fsdic);
		
		//指向硬盘索引库的字符流，true表示如果内存索引库中和硬盘索引库中的相同的document对象时，先删除硬盘索引库中的document对象，
		//再将内存索引库的document对象写入硬盘索引库中
		//反之是false，默认为false，这个boolean值写在硬盘字符流的构造器
		
		IndexWriter indexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), true,LuceneUtil.getMaxFieldLength());
		
		IndexWriter ramindexWriter = new IndexWriter(LuceneUtil.getDirectory(), LuceneUtil.getAnalyzer(), true,LuceneUtil.getMaxFieldLength());
		
		//
		ramindexWriter.addDocument(d);
		ramindexWriter.close();
		
		indexWriter.addDocument(d);
		indexWriter.close();
		
		//将内存索引库的所有document对象同步到硬盘索引库中
		indexWriter.addIndexesNoOptimize(fsdic);
		indexWriter.close();
	}
	
	
	/**
	 * 查看
	 * @throws IllegalAccessException
	 * @throws Exception
	 */
	@Test
	public void findall() throws IllegalAccessException, Exception{
		String keywords = "黄鹏";
		
		List<Article> list = new ArrayList<Article>();
		
		QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(), "content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs search = indexSearcher.search(query, 100);
		
		for(int i=0;i<search.scoreDocs.length;i++){
			ScoreDoc scoreDoc = search.scoreDocs[i];
			int no = scoreDoc.doc;
			Document doc = indexSearcher.doc(no);
			Article article =(Article) LuceneUtil.document2javabean(doc, Article.class);
			list.add(article);
		}
		
		for(Article a : list){
			System.out.println(a);
		}
	}
}
