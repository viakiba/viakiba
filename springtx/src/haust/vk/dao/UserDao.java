package haust.vk.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	
		public List<Map> selectUser();
		
		public void updateUserById(Map map);

		public void deleteUserById(String uid);
		
}
