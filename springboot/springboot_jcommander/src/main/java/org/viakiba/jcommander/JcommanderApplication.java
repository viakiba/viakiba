package org.viakiba.jcommander;

import com.beust.jcommander.JCommander;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JcommanderApplication {

	public static void main(String[] args) {
		//处理命令
		CommandBean commandBean = new CommandBean();
		JCommander jCommander = new JCommander(commandBean);
		try{
			jCommander.setProgramName("JcommanderApplication");
			jCommander.setAcceptUnknownOptions(true);
			jCommander.parse(args);
			System.out.println(commandBean.port);
		}catch (Exception e){
			jCommander.usage();
			e.printStackTrace();
		}
		//对参数进行配置

		/**
		 * 可以重写配置文件 等等
		 */

		//启动
		SpringApplication springApplication = new SpringApplication(JcommanderApplication.class);
		springApplication.run(args);
	}
}
