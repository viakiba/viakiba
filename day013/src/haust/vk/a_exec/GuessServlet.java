package haust.vk.a_exec;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessServlet extends HttpServlet {
	//首先是先产生一个随机数字作为幸运数字
	int lucyNum=0;
	void newGame(){
		Random ran=new Random();
		lucyNum=ran.nextInt(30);
	}
	
	public GuessServlet(){
		newGame();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(lucyNum);//检验随机数，正常
		//设置响应的格式
		resp.setContentType("text/html;charset=utf-8");
		//然后接受数据
		String num=req.getParameter("num");
		Integer nums=null;
		//2.判断辛运数字和用户数字
		//2.1把用户输入的数字转成整数
		if(num!=null&& !num.equals("")){
			nums=Integer.parseInt(num);
		}
		//标记竞猜次数
		Integer times=1;
		//获取当前用户的竞猜次数
		String timeUser=req.getParameter("times");
		if(timeUser!=null && !timeUser.equals("")){
			times = Integer.parseInt(timeUser)+1;
		}
		
		if(times<5){
			String msg="";
			if(nums<lucyNum){
				//小了
				msg = "可惜，小了点";
			}else if(nums>lucyNum){
				//大了
				msg = "可惜，大了点";
			}else{
				msg = "恭喜你，中得1000000元现金大奖,请带身份证到xxx地方领奖！";
				times =null;
			}
			
			//把当前竞猜的次数放入域对象
			req.setAttribute("times", times);
			//把信息放入域对象中
			req.setAttribute("msg", msg);
		}else{
			//产生新的幸运数字
			newGame();
			//游戏结束
			resp.getWriter().write("游戏结束。<a href='"+req.getContextPath()+"/05.guess.jsp'>再来一盘</a>");
			return;
		}
		
		req.getRequestDispatcher("/05.guess.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
