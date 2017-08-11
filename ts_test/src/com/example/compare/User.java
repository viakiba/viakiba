package com.example.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月25日
 */

public class User implements Comparable<User>{
	private int id; 
	private String name; 
	
	
	@Override
	public int compareTo(User o) {
		System.out.println(o.id);
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	public static void main(String[] args) {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		
		user1.id = 1;
		user2.id = 2;
		user3.id = 3;
		user4.id = 4;
		
		user1.name = "tom1";
		user2.name = "tom2";
		user3.name = "tom3";
		user4.name = "tom4";
		
		List<User> list = new ArrayList<User>();
		
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user4);
		
		System.out.println("排序前*******");
		for(User user : list){
			System.out.println(user.toString());
		}
		
		Collections.sort(list);
		System.out.println("排序后*******");
		for(User user : list){
			System.out.println(user.toString());
		}
		
	}
}
