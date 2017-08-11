package com.example.incls;

public class Innerclass {

	private static class innertest {
		static{
			// TODO Auto-generated method stub
			System.out.println("ssssss");
		}
		public static Innerclass SERVICE = new Innerclass();
	}

	public static Innerclass getInstance() {
		return innertest.SERVICE;
	}

	public Innerclass() {
		System.out.println("ceshi");
	}

	public static void main(String[] args) {
		System.out.println("sa");
		Innerclass instance1 = getInstance();
	}
}
