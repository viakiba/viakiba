package haust.vk.d_anno;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月13日
 */
public class App_1 {
	
	//重写父类的方法
	@Override
	public String toString() {
		return super.toString();
	}
	
	//抑制编译器的警告
	@SuppressWarnings(value = { "unused","unchecked" })
	private void save(){
		List list=null;
	}
	
	//标记方法已经过时  
	@Deprecated
	private void save1(){
		
	}
	
	@Test
	public void testMain() throws Exception {
		
	}
}
