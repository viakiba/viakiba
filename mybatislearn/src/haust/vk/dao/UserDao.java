package haust.vk.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	public List<Map> selectUser(String name);
}
