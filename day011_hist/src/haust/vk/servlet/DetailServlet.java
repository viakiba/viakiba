package haust.vk.servlet;

import haust.vk.dao.ProductDao;
import haust.vk.entiry.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String id=req.getParameter("id");
		
		ProductDao dao=new ProductDao();
		Product product=dao.findByid(id);
		
		PrintWriter writer=resp.getWriter();
		String html="";
		
		html += "<html>";
		html += "<head>";
		html += "<title>显示商品详细</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='300px'>";
		if(product!=null){
			html += "<tr><th>编号:</th><td>"+product.getId()+"</td></tr>";
			html += "<tr><th>商品名称:</th><td>"+product.getProName()+"</td></tr>";
			html += "<tr><th>商品型号:</th><td>"+product.getProType()+"</td></tr>";
			html += "<tr><th>商品价格:</th><td>"+product.getPrice()+"</td></tr>";
		}
		
		html += "</table>";
		html += "<center><a href='"+req.getContextPath()+"/ListServlet'>[返回列表]</a></center>";
		html += "</body>";
		html += "</html>";
		
		writer.write(html);
		
		/*
		 * 创建cookie
		 */
		Cookie cookie=new Cookie("prodHist",createValue(req,id));
		cookie.setMaxAge(1*30*24*60*60);//一个月
		resp.addCookie(cookie);

		/**
		 * 生成cookie的值
		 * 分析：
		 * 			当前cookie值                     传入商品id               最终cookie值
		 *      null或没有prodHist          1                     1    （算法： 直接返回传入的id ）
		 *             1                  2                     2,1 （没有重复且小于3个。算法：直接把传入的id放最前面 ）
		 *             2,1                1                     1,2（有重复且小于3个。算法：去除重复id，把传入的id放最前面 ）
		 *             3,2,1              2                     2,3,1（有重复且3个。算法：去除重复id，把传入的id放最前面）
		 *             3,2,1              4                     4,3,2（没有重复且3个。算法：去最后的id，把传入的id放最前面）
		 * @return
		 */
		
	
		
		}
	private String createValue (HttpServletRequest req,String id){
		Cookie[] cookies=req.getCookies();
		String prodHist=null;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("prodHist")){
					prodHist = cookie.getValue();
					break;
				}
			}
		}
		
		if(cookies==null||prodHist==null){
			return id;
		}
		
		String[] ids=prodHist.split(",");
		
		Collection colls=Arrays.asList(ids);
		
		LinkedList list = new LinkedList(colls);
		
		if(list.size()<3){
			//id重复
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
				
			}else{
				list.addFirst(id);
				
			}
		}else{
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else{
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		StringBuffer sb=new StringBuffer();
		for(Object object:list){
			sb.append(object+",");
		}
		String result=sb.toString();
		result=result.substring(0,result.length()-1);
		return result;
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	}

