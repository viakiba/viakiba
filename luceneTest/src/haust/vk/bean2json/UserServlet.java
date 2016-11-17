package haust.vk.bean2json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String page = req.getParameter("page");
		System.out.println("page"+page);
		
		String rows = req.getParameter("rows");
		System.out.println("ROWS"+rows);
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1,"哈哈",1000,"男"));
		userList.add(new User(2,"呵呵",2000,"男"));
		userList.add(new User(3,"嘻嘻",3000,"女"));
		userList.add(new User(4,"笨笨",4000,"男"));
		userList.add(new User(5,"聪聪",5000,"男"));
		userList.add(new User(6,"月月",6000,"女"));
		userList.add(new User(7,"花花",7000,"女"));
		
		Map<String, Object> map = new LinkedHashMap<String,Object>();
		map.put("total", userList.size());
		map.put("rows", userList);
		
		JSONArray jsonArray = JSONArray.fromObject(map);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(jsonArray.toString().substring(1,jsonArray.toString().length()-1));
		pw.flush();
		pw.close();
		
	}
}
