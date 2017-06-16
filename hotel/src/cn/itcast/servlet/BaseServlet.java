package cn.itcast.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IDinnerTableService;
import cn.itcast.service.IFoodService;
import cn.itcast.service.IFoodTypeService;
import cn.itcast.utils.WebUtils;

/**
 * 项目中通用的Servlet，希望所有的servlet都继承此类
 * @author Jie.Yuan
 *
 */
public abstract class BaseServlet extends HttpServlet {
	
	// 创建Service
	protected IDinnerTableService dinnerTableService = 
		BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
	protected IFoodTypeService foodTypeService = 
		BeanFactory.getInstance("foodTypeService",IFoodTypeService.class);
	protected IFoodService foodService = 
		BeanFactory.getInstance("foodService",IFoodService.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// (保存跳转的资源)  方法返回值
		Object returnValue = null;
		
		// 获取操作类型;  【约定 > 俗成： 操作类型的值，必须对应servlet中的方法名称】
		String methodName = request.getParameter("method");  // listTable
		
		try {
			// 1. 获取当前运行类的字节码
			Class clazz = this.getClass();
			// 2. 获取当前执行的方法的Method类型
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			// 3. 执行方法
			returnValue = method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "/error/error.jsp";
		}
		
		// 跳转
		WebUtils.goTo(request, response, returnValue);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
