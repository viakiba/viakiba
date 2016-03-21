package haust.vk.servlet;

import haust.vk.dao.ProductDao;
import haust.vk.entiry.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//读取数据库
		ProductDao dao=new ProductDao();
		List<Product> list=dao.findAll();
		//把商品显示到浏览器里
		PrintWriter writer=resp.getWriter();
		String html="";
		
		html+="<html>";
		html+="<head>";
		html+="<title>显示商品列表";
		html+="</title></head>";
		html+="<body>";
		html+="<table border='1' align='center' width='600px'>";	
		html+="<tr>";
		html+="<th>编号</th>";
		html+="<th>商品名称</th>";
		html+="<th>商品型号</th>";
		html+="<th>价格</th>";
		html+="</tr>";
		
		if(list!=null){
			for(Product p:list){
				html+="<tr>";
				html += "<td>"+p.getId()+"</td><td><a href='"+req.getContextPath()+"/DetailServlet?id="+p.getId()+"'>"+p.getProName()+"</a></td><td>"+p.getProType()+"</td><td>"+p.getPrice()+"</td>";
				html+="<th>商品名称</th>";
				html+="<th>商品型号</th>";
				html+="<th>价格</th>";
				html+="</tr>";
			}
		}
		
		html+="</table>";
		
		html+="最近浏览过的商品 <br/>";
		
		Cookie[] cookies=req.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("prodHist")){
					String str=cookie.getValue();
					String[] ids=str.split(",");
					
					for(String s:ids){
						Product p=dao.findByid(s);
						html +=""+p.getId()+"&nbsp;"+p.getProName()+"&nbsp;"+p.getPrice()+"<br/>";
					}
				}
			}
		}
		html+="</table>";		
		html+="</body>";
		html+="</html>";
		
		writer.write(html);
	}
}
