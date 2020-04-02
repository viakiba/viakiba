package haust.vk.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CityController {
	
	@RequestMapping(value="/test/city")
	public String city(Model model,HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("city");
		return "index";
	}
}
