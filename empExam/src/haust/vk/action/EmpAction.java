package haust.vk.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haust.vk.entity.Emp;
import haust.vk.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpAction {
	private EmpService empService;
	
	@Resource(name="empService")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	@RequestMapping("/findAllEmpMethod")
	public @ResponseBody Map<String,Object> findAllEmpMethod() throws Exception{
		List<Emp> list = empService.findAllEmp();
		System.out.println(list);
		Map<String,Object> map = new LinkedHashMap<String, Object>();
		//封装DataGrid需要的二个参数
		map.put("total", list.size());
		map.put("rows", list);
		
		System.out.println(map);
		//@ResponseBody  自动转换为json
		return map;
	}
}

/*
[haust.vk.entity.Emp@696bdc33, haust.vk.entity.Emp@2845ce57, haust.vk.entity.Emp@7eedc668, haust.vk.entity.Emp@2c7d16f2, haust.vk.entity.Emp@486d80af, haust.vk.entity.Emp@d1b864f, haust.vk.entity.Emp@a0eb342, haust.vk.entity.Emp@4b1ab736, haust.vk.entity.Emp@46f260bf, haust.vk.entity.Emp@52adbffc, haust.vk.entity.Emp@d1763cc, haust.vk.entity.Emp@7a98ecca, haust.vk.entity.Emp@4de200a7, haust.vk.entity.Emp@3098fbe3]
{total=14, rows=[haust.vk.entity.Emp@696bdc33, haust.vk.entity.Emp@2845ce57, haust.vk.entity.Emp@7eedc668, haust.vk.entity.Emp@2c7d16f2, haust.vk.entity.Emp@486d80af, haust.vk.entity.Emp@d1b864f, haust.vk.entity.Emp@a0eb342, haust.vk.entity.Emp@4b1ab736, haust.vk.entity.Emp@46f260bf, haust.vk.entity.Emp@52adbffc, haust.vk.entity.Emp@d1763cc, haust.vk.entity.Emp@7a98ecca, haust.vk.entity.Emp@4de200a7, haust.vk.entity.Emp@3098fbe3]}


*/