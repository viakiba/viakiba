package haust.vk.highlighter;

import haust.vk.entity.Article;
import haust.vk.util.LuceneUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.junit.Test;

public class ArticleDao {
	
	@Test
	public void findAll() throws Exception{
		String keywords = "培训";
		List<Article> list = new ArrayList<Article>();
		
		QueryParser queryParser = new QueryParser(LuceneUtil.getVersion(), "content", LuceneUtil.getAnalyzer());
		Query query = queryParser.parse(keywords);
		IndexSearcher indexSearcher = new IndexSearcher(LuceneUtil.getDirectory());
		TopDocs topDocs = indexSearcher.search(query, 100);
		
		//以下代码对内容中含有关键字的字符串高亮显示
		
		//格式对象
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
		//关键字对象
		QueryScorer scorer = new QueryScorer(query);
		//高亮对象
		Highlighter highlighter = new Highlighter(formatter, scorer);
		
		for(int i=0;i<topDocs.scoreDocs.length;i++){
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			
			//关键字还没有高亮
			Document doc = indexSearcher.doc(no);
			
			//关键字高亮
			String titleHign = highlighter.getBestFragment(LuceneUtil.getAnalyzer(), "title",doc.get("title"));
			
			String contentHign = highlighter.getBestFragment(LuceneUtil.getAnalyzer(), "content",doc.get("content"));
		
			//将高亮后的结果再次封装到document对象中
			doc.getField("title").setValue(titleHign);
			doc.getField("content").setValue(contentHign);
			
			//
			 Article article = (Article) LuceneUtil.document2javabean(doc, Article.class);
			 list.add(article);
		}
		
		for(Article a  : list){
			System.out.println(a);
		}
	}
}
