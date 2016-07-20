package haust.vk.e_aop_anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 目标对象
 * @author viakiba
 *
 */
@Component
@Scope("prototype")
public class OrderDao {
	public void save() {
		System.out.println("===========核心业务：保存！！！=============");
	}
}
