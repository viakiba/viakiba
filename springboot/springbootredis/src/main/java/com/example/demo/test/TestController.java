package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月11日
 */

@RestController
@RequestMapping("")
public class TestController {
	
	/** 
	 * @description: 
	 * @author: viakiba 
	 */
	@RequestMapping("/testmapping")
	public Map testMapping() {
		// TODO Auto-generated method stub
		Map map = new HashMap<>();
		map.put("name", "jack");
		map.put("password", "password");
		return map;
	}
}
