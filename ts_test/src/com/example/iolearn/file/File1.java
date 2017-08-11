package com.example.iolearn.file;

import java.io.File;
import java.text.SimpleDateFormat;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年8月7日
 */

public class File1 {
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\demo.txt");
		System.out.println(file.exists());
//		if(file.exists()){
//			file.delete();
//		}else{
//			boolean createNewFile = file.createNewFile();
//			System.out.println(createNewFile);
//		}
		System.out.println(file.lastModified());
		
		File file2 = new File("D:"+File.separator+"demo");
		System.out.println(file2.isDirectory());
		
		System.out.println(file2.listFiles()[0]);
		System.out.println(file2.getFreeSpace());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
		System.out.println(simpleDateFormat.format(file.lastModified()));
		System.out.println();
		System.out.println();
	}
}
