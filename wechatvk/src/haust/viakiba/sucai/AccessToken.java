package haust.viakiba.sucai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class AccessToken {
	/**
	 * appid = wxa17362dca38f150f
	 * AppSecret = 3648cdb2de711f6faa19244c7d6f4631
	 * get 地址  https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	 * @return Access token   json 数据   {"access_token":"ACCESS_TOKEN","expires_in":7200}
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	
	public static String getAccessToken() throws ClientProtocolException, IOException{
		String appid = "wx32f1fdf5edf36bfb";
		String AppSecret = "00331d6bac9330b7d7020fa8eb6e4721";
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+AppSecret;
		
		//System.out.println(url);
		
		HttpGet httpget = new HttpGet(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = httpclient.execute(httpget);
		
		//对于返回实体进行解析
		HttpEntity entity = response.getEntity();
		InputStream returnStream = entity.getContent();
		BufferedReader reader = new BufferedReader(
						new InputStreamReader(returnStream, "utf-8"));
		StringBuilder result = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) {
				result.append(str).append("\n");
			}
		//
		return result.toString();
	}
}
