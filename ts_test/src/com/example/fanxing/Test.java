package com.example.fanxing;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws Exception {
		Class<?> forName = Class.forName("com.example.fanxing.Demo");
		Method[] methods = forName.getMethods();
		System.out.println(methods.length);
		System.out.println(methods[0].getName());
		
		Method method = forName.getMethod("getIer", int.class);
		method.invoke(Demo.class.newInstance(), 1);
	}
}
