package haust.vk.f_log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * @author vk
 *
 * 2016年5月13日
 */
public class App {
	
	Log log = LogFactory.getLog(App.class);
	
	@Test
	public void save() {
		try {
			log.info("保存： 开始进入保存方法");

			int i = 1/0;
			
			log.info("保存： 执行保存结束，成功");
		} catch (Exception e) {
			
			log.error("执行App类Save()方法出现异常！");  // 异常
			
			e.printStackTrace();
		}
	}
	
	/*
	 * 思考： 日志的输出级别作用？
	 * 	 ----> 控制日志输出的内容。
	 */
	@Test
	public void testLog() throws Exception {
		// 输出不同级别的提示
		log.debug("调试信息");
		log.info("信息提示");
		log.warn("警告");
		log.error("异常");
		
	}
}
