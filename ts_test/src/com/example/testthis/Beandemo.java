package com.example.testthis;

import org.junit.Test;

public class Beandemo {
	
	private int flag ;
	
	public Beandemo(int flag){
		this.flag = flag;
	}
	
	@Test
	public void test(){
		Beandemo beandemo = new Beandemo(1);
		beandemo.help();
	}
	
	public void help(){
		System.out.println(Thread.currentThread().getName());
		System.out.println(flag+"<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
	}
	
	public static void main(String[] args) {
		Beandemo beandemo = new Beandemo(1);
		beandemo.help();
	}
}
