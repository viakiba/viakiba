package haust.viakiba.sucai;

import haust.viakiba.sucai.entity.AccessTokenBean;
import haust.viakiba.sucai.entity.BlogJava;
import haust.viakiba.sucai.entity.Haoqixin;
import haust.viakiba.sucai.entity.Ke36;
import haust.viakiba.sucai.entity.One;
import haust.viakiba.sucai.entity.Sspai;
import haust.viakiba.sucai.entity.Zhihu;
import haust.viakiba.sucai.url2bean.BlogJava2bean;
import haust.viakiba.sucai.url2bean.Haoqixin2bean;
import haust.viakiba.sucai.url2bean.Ke362bean;
import haust.viakiba.sucai.url2bean.One2bean;
import haust.viakiba.sucai.url2bean.Sspai2bean;
import haust.viakiba.sucai.url2bean.Zhihu2Listbean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Shangchuan {
	/*
	 * 好奇心：http://www.qdaily.com/feed.xml
	 * ONE : http://onehd.herokuapp.com/
	 * 少数派：http://sspai.com/feed
	 * 知乎： https://www.zhihu.com/rss
	 * 36kr:http://36kr.com/feed
	 * blogjava: http://www.blogjava.net/rss
	 */
	private static URL url1=null;
	private static URL url2=null;
	private static URL url3=null;
	private static URL url4=null;
	private static URL url5=null;
	private static URL url6=null;
	
	public static String getMedia_id() throws Exception{
		//设置url
		url1 = new URL("http://www.qdaily.com/feed.xml");
		url2 = new URL("http://onehd.herokuapp.com/");
		url3 = new URL("http://sspai.com/feed");
		url4 = new URL("https://www.zhihu.com/rss");
		url5 = new URL("http://36kr.com/feed");
		url6 = new URL("http://www.blogjava.net/rss");
		//获取素材
		List<Haoqixin> list_hqx = Haoqixin2bean.getZhiFromUrl(url1);
		List<One> list_one = One2bean.getZhiFromUrl(url2);
		List<Sspai> list_ssp = Sspai2bean.getZhiFromUrl(url3);
		List<Zhihu> list_zhi = Zhihu2Listbean.getZhiFromUrl(url4);
		List<Ke36> list_k36 = Ke362bean.getZhiFromUrl(url5);
		List<BlogJava> list_bjb = BlogJava2bean.getZhiFromUrl(url6);
		//素材获取完成   获取teken
		String accessToken = AccessToken.getAccessToken();
		AccessTokenBean atbean = JSON.parseObject(accessToken, AccessTokenBean.class);
		
		//上传图片 获取图文封面 id
		
		
		
		
		
		
		//组装素材
		StringBuffer hqx=new StringBuffer();
		StringBuffer one=new StringBuffer();
		StringBuffer ssp=new StringBuffer();
		StringBuffer zhi=new StringBuffer();
		StringBuffer k36=new StringBuffer();
		StringBuffer bjb=new StringBuffer();
		
		//好奇心
		hqx.append("{  \"articles\": [");
		for(int i=0; i<5 ; i++){
			hqx.append("{\"title\":"
					+list_hqx.get(i).getTitle()
					+",\"thumb_media_id\": "+null
					+"\"author\": "+list_hqx.get(i).getTitle()
					+"\"digest\": "+null
					+"\"show_cover_pic\":"+0
					+"\"content\": "+list_hqx.get(i).getDescription()
					+"\"content_source_url\":"+list_hqx.get(i).getLink()
					+" },");
		}
		
		
		one.append("{  \"articles\": [");
		for(int i=0; i<3 ; i++){
			hqx.append("{\"title\":"
					+list_one.get(i).getTitle()
					+",\"thumb_media_id\": "+null
					+"\"author\": "+list_one.get(i).getAuthor()
					+"\"digest\": "+null
					+"\"show_cover_pic\":"+0
					+"\"content\": "+list_one.get(i).getDescription()
					+"\"content_source_url\":"+list_one.get(i).getLink()
					+" },");
		}
		
		ssp.append("{  \"articles\": [");
		for(int i=0; i<3 ; i++){
			hqx.append("{\"title\":"
					+list_ssp.get(i).getTitle()
					+",\"thumb_media_id\": "+null
					+"\"author\": "+list_ssp.get(i).getCreator()
					+"\"digest\": "+null
					+"\"show_cover_pic\":"+0
					+"\"content\": "+list_ssp.get(i).getDescription()
					+"\"content_source_url\":"+list_ssp.get(i).getLink()
					+" },");
		}
		
		zhi.append("{  \"articles\": [");
		for(int i=0; i<5 ; i++){
			hqx.append("{\"title\":"
					+list_zhi.get(i).getTitle()
					+",\"thumb_media_id\": "+null
					+"\"author\": "+list_zhi.get(i).getTitle()
					+"\"digest\": "+null
					+"\"show_cover_pic\":"+0
					+"\"content\": "+list_zhi.get(i).getDescription()
					+"\"content_source_url\":"+list_zhi.get(i).getLink()
					+" },");
		}
		
		k36.append("{  \"articles\": [");
		for(int i=0; i<5 ; i++){
			hqx.append("{\"title\":"
					+list_k36.get(i).getTitle()
					+",\"thumb_media_id\": "+null
					+"\"author\": "+list_k36.get(i).getAuther()
					+"\"digest\": "+null
					+"\"show_cover_pic\":"+0
					+"\"content\": "+list_k36.get(i).getDescription()
					+"\"content_source_url\":"+list_k36.get(i).getLink()
					+" },");
		}
		
		bjb.append("{  \"articles\": [");
		for(int i=0; i<5 ; i++){
			hqx.append("{\"title\":"
					+list_bjb.get(i).getTitle()
					+",\"thumb_media_id\": "+null
					+"\"author\": "+list_bjb.get(i).getAuthor()
					+"\"digest\": "+null
					+"\"show_cover_pic\":"+0
					+"\"content\": "+list_bjb.get(i).getDescription()
					+"\"content_source_url\":"+list_bjb.get(i).getLink()
					+" },");
		}
			
		//发送素材   
		
		
		
		//清空stringbuffer
		
		
		//获取id   存入 xml  dom4j
		
		
		return null;
	}
	
}
