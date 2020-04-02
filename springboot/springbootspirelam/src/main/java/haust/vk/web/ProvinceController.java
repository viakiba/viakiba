package haust.vk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProvinceController {
	@RequestMapping(value="/test/province")
	public String city(){
		System.out.println("province");
		return "index";
	}
}
