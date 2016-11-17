package haust.vk.fy.action;

import haust.vk.fy.entity.Page;
import haust.vk.fy.service.ArticleService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class ArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
			
			String keywords = request.getParameter("keywords");
			if(keywords == null || keywords.trim().length() == 0){
				keywords = "培训";
			}
			
			String temp = request.getParameter("page");
			
			if(temp == null || temp.trim().length() == 0){
				temp="1";
			}
			
			//调用service层
			ArticleService articleService = new ArticleService();
			Page page = articleService.show(keywords, Integer.valueOf(temp));
			
			//构造Map对象
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("total", page.getAllRecordNO());
			map.put("rows", page.getArticleList());
			
			//第三方工具将Map转成JSON
			JSONArray jsonArray = JSONArray.fromObject(map);
			String str = jsonArray.toString();
			
			//去掉二边的[]符号
			str = str.substring(1, str.length()-1);
			
			//以IO的流方式响应到DataGrid组件
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(str);
			pw.flush();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
