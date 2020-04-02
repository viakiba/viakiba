package haust.viakiba.translate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class TranslateUtil{
	
	private static final String UTF8 = "utf-8";
	
	//申请者开发者id，实际使用时请修改成开发者自己的appid
	private static final String appId = "20160723000025676";

	//申请成功后的证书token，实际使用时请修改成开发者自己的token
	private static final String token = "HTlanalXuS0l5RB6xprR";

	private static final String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

	//随机数，用于生成md5值，开发者使用时请激活下边第四行代码
	private static final Random random = new Random();
	
	public String translate(String q, String from, String to) throws Exception{
		//用于md5加密
		int salt = random.nextInt(10000);
		//本演示使用指定的随机数为1435660288
		//int salt = 1435660288;
		
		// 对appId+源文+随机数+token计算md5值
		StringBuilder md5String = new StringBuilder();
		md5String.append(appId).append(q).append(salt).append(token);
		String md5 = DigestUtils.md5Hex(md5String.toString());

		//使用Post方式，组装参数
		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
		nvps.add(new BasicNameValuePair("q", q));  
		   nvps.add(new BasicNameValuePair("from", from));  
		   nvps.add(new BasicNameValuePair("to", to));  
		   nvps.add(new BasicNameValuePair("appid", appId));  
		   nvps.add(new BasicNameValuePair("salt", String.valueOf(salt)));  
		   nvps.add(new BasicNameValuePair("sign", md5));  
		httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));  

		//创建httpclient链接，并执行
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    CloseableHttpResponse response = httpclient.execute(httpost);
	    
	    //对于返回实体进行解析
		HttpEntity entity = response.getEntity();
		InputStream returnStream = entity.getContent();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(returnStream, UTF8));
		StringBuilder result = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) {
			result.append(str).append("\n");
		}
		
		//转化为json对象，注：Json解析的jar包可选其它
		JSONObject resultJson = new JSONObject(result.toString());

		//开发者自行处理错误，本示例失败返回为null
		try {
			String error_code = resultJson.getString("error_code");
			if (error_code != null) {
				System.out.println("出错代码:" + error_code);
				System.out.println("出错信息:" + resultJson.getString("error_msg"));
				return "翻译失败";
			}
		} catch (Exception e) {}
		
		//获取返回翻译结果
		JSONArray array = (JSONArray) resultJson.get("trans_result");
		JSONObject dst = (JSONObject) array.get(0);
		String text = dst.getString("dst");
		text = URLDecoder.decode(text, UTF8);

		return text;
	}
	
	//实际抛出异常由开发者自己处理
	public static  String translateToEn(String q,char target) throws Exception{
		ApplicationContext container=new FileSystemXmlApplicationContext("classpath:/haust/viakiba/translate/baidu.xml");
		TranslateUtil baidu = (TranslateUtil)container.getBean("tran");
		
		String result = null;
		
		try {
			
			switch(target){
				//翻译为中文
				case 'z' :result = baidu.translate(q, "auto", "zh");break;
				case 'Z' :result = baidu.translate(q, "auto", "zh");break;
				//翻译为英文
				case 'e' :result = baidu.translate(q, "auto", "en");break;
				case 'E' :result = baidu.translate(q, "auto", "en");break;
				//翻译为韩文
				case 'h' :result = baidu.translate(q, "auto", "kor");break;
				case 'H' :result = baidu.translate(q, "auto", "kor");break;
				//翻译为日文
				case 'j' :result = baidu.translate(q, "auto", "jp");break;
				case 'J' :result = baidu.translate(q, "auto", "jp");break;
				
				default:
					result = "不支持目标语言";
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
