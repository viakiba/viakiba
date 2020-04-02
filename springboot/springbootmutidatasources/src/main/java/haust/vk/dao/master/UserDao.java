package haust.vk.dao.master;

import haust.vk.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
	User findByName(@Param("userName") String userName);
}
