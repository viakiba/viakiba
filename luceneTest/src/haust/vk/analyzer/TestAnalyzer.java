package haust.vk.analyzer;

import haust.vk.util.LuceneUtil;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 测试Lucene内置和第三方分词器的效果
 * @author viakiba
 *
 */
public class TestAnalyzer {

	private static void testAnalyzer(Analyzer analyzer,String text) throws Exception{
		System.out.println("当前使用的分词器: " + analyzer.getClass());
		TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
		
		tokenStream.addAttribute(TermAttribute.class);
		
		while(tokenStream.incrementToken()){
			TermAttribute termAttribute = tokenStream.getAttribute(TermAttribute.class);
			System.out.println(termAttribute.term());
		}
	}
	
	public static void main(String[] args) throws Exception {
		//testAnalyzer(new StandardAnalyzer(LuceneUtil.getVersion()),"传智播客说我们的首都是北京呀it");
		//testAnalyzer(new ChineseAnalyzer(),"传智播客说我们的首都是北京呀it");
		testAnalyzer(new IKAnalyzer(),"传智播客说我们的首都是北京");
	}
}
