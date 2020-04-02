# wechatvk

## 微信公众号 -viakiba
### 一.说明
此工程使用得java语言进行的开发。

### 二：具体功能

####2.1 
 
新增 语音翻译（尝试说   翻译 happy），语音查新闻(说新闻)，等众多功能。试着说一下你想说的，看会回复什么？
 

####2.0  
 
新增   快递(m+快递号 如  m1234567891011)，对话功能（支持语音和文本）
 
####1.1  
 
新增翻译功能 接入了百度翻译 (如（大小写不敏感 下同） 翻译成中文  tzhappy，翻译成日文 tj你好 ，翻译成韩文，th你好 ，翻译成英文 te你好)
 

####1.0 
  支持天气查询（众多查询姿势，比如语音 说（郑州天气），发送坐标 （点击邮编加号，选择发送为止），
发送 w+城市名称（wbeijing/Wbeijing）  ）
 

####源码：
 
www.github.com/viakiba/wechatvk

####接口权限
https://mp.weixin.qq.com/advanced/advanced?action=table&token=392088771&lang=zh_CN

### 代码说明：
#### 工具类
PostServerCheat
使用post发送json数据到url上得到响应的字符串(json)数据返回 

	public static String SendPost(String param, String url) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);//创建url
			//创建conn并设置响应头
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(50000);
			conn.setReadTimeout(50000);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "token");
			conn.setRequestProperty("tag", "htc_new");

			conn.connect();
			//设置发出的内容并设置编码
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			//发送数据
			out.write(param);
			//清空 关闭
			out.flush();
			out.close();
			//接送数据
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line = "";
			//读取数据
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	    

#### 聊天功能：
 
接入的是[图灵机器人](www.tuling123.com).
请求是发送那个带有三个字段的json，响应四种json数据。
具体查看官网api。
核心代码如下：
	   

		JSONObject json = new JSONObject();//封装数据
		json.put("key", apiKey);
		json.put("info", info);
		json.put("userid", userid);
		
		//System.out.println(json.toString());
		
		//请求图灵api  使用工具类 PostServerCheat
		info = PostServerCheat.SendPost(json.toString(),url);
		
		//文本事件
		//System.out.println("{\"code\":100000");
		//处理json
		if(info.startsWith("{\"code\":100000")){

			WenBen wenben = JSON.parseObject(info,WenBen.class);
			StringBuffer sb = new StringBuffer();
			sb.append(wenben.getText());
			return sb.toString();
			
			//System.out.println(wenben.getCode());
		}
	   
#### 快递单号查询
使用的是 [快递鸟 api](www.tuling123.com).
主要创建的两个工具类 公司代码查询 与 物流状态查询   代码待精简
##### 公司代码查询

	public class KdApiOrderDistinguish {
	private static JsonsRootBeanGs business;
	
	public static JsonsRootBeanGs getJsonsRootBean(String dh) {
		KdApiOrderDistinguish api = new KdApiOrderDistinguish();
		try {
			String result = api.getOrderTracesByJson(dh);
			
			business = JSON.parseObject(result,JsonsRootBeanGs.class);
			return business;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return business;
		}
	}
	
	//电商ID
	private String EBusinessID="id";
	//电商加密私钥，快递鸟提供，注意保管，不要泄漏
	private String AppKey="Appkey";
	//请求url
	private String ReqURL="http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";	
 
	/**
     * Json方式 单号识别
	 * @throws Exception 
     */
	public String getOrderTracesByJson(String expNo) throws Exception{
		//组装字符串 json
		String requestData= "{'LogisticCode':'" + expNo + "'}";
		
		Map<String, String> params = new HashMap<String, String>();
		//组装请求数据
		params.put("RequestData", urlEncoder(requestData, "UTF-8"));
		params.put("EBusinessID", EBusinessID);
		params.put("RequestType", "2002");
		//获取加密数据
		String dataSign=encrypt(requestData, AppKey, "UTF-8");
		//组装加密数据
		params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
		params.put("DataType", "2");
		//发送
		String result=sendPost(ReqURL, params);	
		
		//根据公司业务处理返回的信息......
		
		return result;
	}
 
	/**
     * MD5加密
     * @param str 内容       
     * @param charset 编码方式
	 * @throws Exception 
     */
	@SuppressWarnings("unused")
	private String MD5(String str, String charset) throws Exception {
		//初始化md5 对象
	    MessageDigest md = MessageDigest.getInstance("MD5");
		//获取
	    md.update(str.getBytes(charset));
		//
	    byte[] result = md.digest();
	    StringBuffer sb = new StringBuffer(32);
	    for (int i = 0; i < result.length; i++) {
	        int val = result[i] & 0xff;
	        if (val <= 0xf) {
	            sb.append("0");
	        }
	        sb.append(Integer.toHexString(val));
	    }
		//都是小写
	    return sb.toString().toLowerCase();
	}
	
	/**
     * base64编码 使用的base64Encode方法 在下面
     * @param str 内容       
     * @param charset 编码方式
	 * @throws UnsupportedEncodingException 
     */
	private String base64(String str, String charset) throws UnsupportedEncodingException{
		String encoded = base64Encode(str.getBytes(charset));
		return encoded;    
	}	
	
	@SuppressWarnings("unused")
	private String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
		String result = URLEncoder.encode(str, charset);
		return result;
	}
	
	/**
	 * 计算md5 在使用base64加密
     * 电商Sign签名生成
     * @param content 内容   
     * @param keyValue Appkey  
     * @param charset 编码方式
	 * @throws UnsupportedEncodingException ,Exception
	 * @return DataSign签名
     */
	@SuppressWarnings("unused")
	private String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception
	{
		if (keyValue != null)
		{
			return base64(MD5(content + keyValue, charset), charset);
		}
		return base64(MD5(content, charset), charset);
	}
	
	 /**
     * 向指定 URL 发送POST方法的请求     
     * @param url 发送请求的 URL    
     * @param params 请求的参数集合     
     * @return 远程资源的响应结果
     */
	@SuppressWarnings("unused")
	private String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;        
        StringBuilder result = new StringBuilder(); 
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数            
            if (params != null) {
		          StringBuilder param = new StringBuilder(); 
		          for (Map.Entry<String, String> entry : params.entrySet()) {
		        	  if(param.length()>0){
		        		  param.append("&");
		        	  }	        	  
		        	  param.append(entry.getKey());
		        	  param.append("=");
		        	  param.append(entry.getValue());		        	  
		        	  //System.out.println(entry.getKey()+":"+entry.getValue());
		          }
		          //System.out.println("param:"+param.toString());
		          out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {            
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
	
	
    private static char[] base64EncodeChars = new char[] { 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
        'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
        'w', 'x', 'y', 'z', '0', '1', '2', '3', 
        '4', '5', '6', '7', '8', '9', '+', '/' }; 
	
    public static String base64Encode(byte[] data) { 
        StringBuffer sb = new StringBuffer(); 
        int len = data.length; 
        int i = 0; 
        int b1, b2, b3; 
        while (i < len) { 
            b1 = data[i++] & 0xff; 
            if (i == len) 
            { 
                sb.append(base64EncodeChars[b1 >>> 2]); 
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]); 
                sb.append("=="); 
                break; 
            } 
            b2 = data[i++] & 0xff; 
            if (i == len) 
            { 
                sb.append(base64EncodeChars[b1 >>> 2]); 
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]); 
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]); 
                sb.append("="); 
                break; 
            } 
            b3 = data[i++] & 0xff; 
            sb.append(base64EncodeChars[b1 >>> 2]); 
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]); 
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]); 
            sb.append(base64EncodeChars[b3 & 0x3f]); 
        } 
        return sb.toString(); 
    }
	}
	
#### 物流状态查询 与单号类似
	略
	
#### 翻译
使用的是  [百度翻译 api](http://api.fanyi.baidu.com/api/trans/product/index)
核心代码：

	public class TranslateUtil{
	
	private static final String UTF8 = "utf-8";
	
	//申请者开发者id，实际使用时请修改成开发者自己的appid
	private static final String appId = "APPID"//自己申请

	//申请成功后的证书token，实际使用时请修改成开发者自己的token
	private static final String token = "TOKEN" //自己申请

	private static final String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

	
	private static final Random random = new Random();
	
	public String translate(String q, String from, String to) throws Exception{
		//用于md5加密
		int salt = random.nextInt(10000);
		
		
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
	
使用了spring框架的支持
	
	<bean id="tran" class="haust.viakiba.translate.TranslateUtil"/>
	
#### 天气查询
	url拼接：

		public static String loadJson (String url) {  //返回json字符串
	       StringBuilder json = new StringBuilder();  
	       try {  
	           URL urlObject = new URL(url);  
	           URLConnection uc = urlObject.openConnection();  
	           BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));  
	           String inputLine = null;  
	           while ( (inputLine = in.readLine()) != null) {  
	              json.append(inputLine);  
	           }  
	           in.close();  
	         } catch (Exception e) {  
	             e.printStackTrace();  
	         }  
	         return json.toString();  
	     }
	
#### 素材的下载使用的是xml解析 dom4j
	
	//获取document
	public static Document getDoc(URL url) throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(url);
		return doc;
	}
	
	//转为List<java>
	public static List<BlogJava> getZhiFromUrl(URL url) throws Exception{
		List<BlogJava> list = new ArrayList<BlogJava>();
		Document doc = Xml2Doc.getDoc(url);
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) doc.selectNodes("/rss/channel/item");
		int i = 0;
		for(Element e:items){
			BlogJava sspai = new BlogJava();
			
			sspai.setTitle(e.elementText("title"));
			sspai.setAuthor(e.elementText("author"));
			sspai.setLink(e.elementText("link"));
			sspai.setDescription(e.elementText("description"));
			sspai.setPubDate("pubDate");
			i++;//控制读取数量为5
			if(i==6){
				break;
			}
			list.add(sspai);
		}
		return list;
	}
	
#### xml转map
	

	public static Map<String , String > Xml2Map(HttpServletRequest req) throws Exception{//Xml转Map
		SAXReader reader = new SAXReader();
		Map<String , String > map = new HashMap<String, String>();
		
		InputStream ins = req.getInputStream();
		Document doc = reader.read(ins);
		
		Element rootElement = doc.getRootElement();
		List<Element> list = rootElement.elements();
		ins.close();
		
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		return map;
	}
	
#### bean 转 textXml  使用了XStream
	
	import com.thoughtworks.xstream.XStream;
	public static String beantoTextXml(MessageTextBean mtb){
		XStream xst = new XStream();
		
		String fromUserName = mtb.getFromUserName();
		String toUserName = mtb.getToUserName();
		
		
		
		xst.alias("xml", mtb.getClass());//标签对与属性名一致 跟标签设置为xml
		
		String mtbBean2Str=xst.toXML(mtb);
		
		return mtbBean2Str;
	}
	

#### 注意
	servlet中的控制逻辑主要使用switch嵌套实现  
	部分utils包中的工具类在开发过程中没有使用。
	json转bean使用的是jar包支持。json生成实体类使用的是在线工具。
 
 
