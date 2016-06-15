package haust.vk.b_config;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月14日
 */
public class TestActiion extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("TestActiion.execute");
		return SUCCESS;
	}
}
