package com.yuncanting.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络请求工具类
 */
@Component
public class UrlReqestUtil {
    /**
     * 返回json字符串  get
     * @param url
     * @return
     * @throws Exception
     */
    public String loadJson (String url) throws Exception {
        StringBuilder json = new StringBuilder();
        BufferedReader in = null;
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            uc.setRequestProperty("Accept", "application/json");
            in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        }finally{
            if(in != null){
                in.close();
            }
        }
        return json.toString();
    }

    /**
     * 返回json字符串  post
     * @param strURL
     * @param params
     * @return
     * @throws Exception
     */
    public String loadJson(String strURL,String params) throws Exception{
        OutputStreamWriter out = null;
        InputStream is = null;
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            //connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            out = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();
            // 读取响应
            int length = (int) connection.getContentLength();// 获取长度
            is = connection.getInputStream();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码
                System.out.println(result);
                return result;
            }
        }finally{
            if(out != null){
                out.close();
            }
            if(is != null){
                is.close();
            }
        }
        return "error"; // 自定义错误信息
    }
}
