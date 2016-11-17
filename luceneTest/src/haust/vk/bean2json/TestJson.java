package haust.vk.bean2json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.junit.Test;

/**
 * 演示用第三方工具类 将javabean List Map 转成json
 * @author viakiba
 *
 */
public class TestJson {
	
	@Test
	public void javabean2json(){
		User user = new User(1,"哈哈",7000,"男");
		
		JSONArray fromObject = JSONArray.fromObject(user);
		System.out.println(fromObject.toString());
	}
	
	@Test
	public void list2json(){
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"班长",7000,"男"));
		list.add(new User(2,"班长老婆",8000,"男"));
		list.add(new User(3,"班长小孩",20000,"男"));
		
		JSONArray fromObject = JSONArray.fromObject(list);
		System.out.println(fromObject.toString());
		
	}
	
	@Test
	public void map2json(){
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1,"班长",7000,"男"));
		userList.add(new User(2,"班长老婆",8000,"女"));
		userList.add(new User(3,"班长小孩",20000,"男"));
		userList.add(new User(4,"班长小孩的小孩",40000,"男"));
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", userList.size());
		map.put("rows", userList);
		
		JSONArray json = JSONArray.fromObject(map);
		System.out.println(json.toString());
		
		String str = json.toString().substring(1,json.toString().length());
		System.out.println(str);
	}
}
