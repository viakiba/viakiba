package haust.vk.ongl;

import ognl.Ognl;
import ognl.OgnlContext;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年6月17日
 */
public class OnglDemo1 {
	
	/**
	 * 1. Ognl表达式语言语言取值，取非根元素的值，必须用#号
	 * @throws Exception
	 */
	@Test
	public void testOngl() throws Exception{
		//创建一个Ongl上下文对象
		OgnlContext context=new OgnlContext();
		//初始化设置数据
		User user = new User();
		user.setId(20);
		user.setName("Tack");
		//放入数据
		context.put("user", user);
		//获取数据  （map）  先构建一个Ongl表达式 
		Object ognl = Ognl.parseExpression("#user.name");
		//解析表达式 获取数据
		Object value = Ognl.getValue(ognl, context,context.getRoot());
		//输出效果
		System.out.println(value);
	}
	
	/**
	 * 2. Ognl表达式语言语言取值，取根元素的值，不用带#号
	 * @throws Exception
	 */
	@Test
	public void testOngl2() throws Exception{
		OgnlContext context = new OgnlContext();
		//初始化设置数据
		User user = new User();
		user.setId(20);
		user.setName("Tack");
		
		//放入数据  设置为根元素   则获取是不需要使用   #
		context.setRoot(user);
		
		//先构建Ognl表达式 在解析map
		Object ognl = Ognl.parseExpression("address.province");
		//获取map
		Object value = Ognl.getValue(ognl, context ,context.getRoot());
		//输出
		System.out.println(value);
	}
	
	/**
	 * 3.Ognl对 静态方法调用的支持
	 * @throws Exception
	 */
	@Test
	public void testOgnl3() throws Exception{
		OgnlContext context = new OgnlContext();
		
		// Ognl表单式语言，调用类的静态方法
		//Object ognl = Ognl.parseExpression("@Math@floor(10.9)");
		
		Object ognl = Ognl.parseExpression("@@floor(10.1)");
		// 由于Math类在开发中比较常用，所以也可以这样写
		Object value = Ognl.getValue(ognl, context, context.getRoot());
		
		System.out.println(value);
	}
}
