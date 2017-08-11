package com.example.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo1 {
	public static void main(String[] args) {
//		try {
//			String str = "cmd /d cd mkdir ls";
//			System.out.println(str);
//			Process exec = Runtime.getRuntime().exec(str);
//			System.out.println(exec.isAlive());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		Runtime runtime=Runtime.getRuntime();
//		try{
//			runtime.exec("cmd /c start javac -v");
//			runtime.exec("cmd /c start dir");
//			runtime.exec("cmd /c start C://a.txt");
//			runtime.exec("cmd /k start mkdir ls");
//			runtime.exec("cmd \\c\\Users\\Administrator\\Desktop\\1.bat");
//			runtime.exec("cmd /c start mkdir ls");
//		}catch(Exception e){
//			System.out.println("Error!");
//		}
		
		/*
			mkdir ls
		 */
		 try {
        	String command = "C:\\Users\\Administrator\\Desktop\\1.bat";
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));//注意中文编码问题
            String line;
            while ((line = br.readLine()) != null) {
            	System.out.println("StartedLog==>"+line);
            }
            br.close();
		 } catch (IOException e) {
			 e.printStackTrace();
       }
	}
}
