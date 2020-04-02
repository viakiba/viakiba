package haust.vk.service;

import haust.vk.entity.User;

public interface UserService {
	User findByName(String userName);
}
