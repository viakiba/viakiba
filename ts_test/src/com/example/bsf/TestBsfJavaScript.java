package com.example.bsf;

import java.io.File;
import java.io.IOException;

import org.apache.bsf.BSFException;
import org.apache.bsf.BSFManager;
import org.apache.commons.io.FileUtils;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月13日
 */

public class TestBsfJavaScript {
	
	public String config ;
	public String viakiba ;
	
	public static void main(String[] args) throws BSFException, IOException {
		String path = TestBsfJavaScript.class.getClassLoader().getResource("").getPath();

		BSFManager bsfManager = new BSFManager();
		TestBsfJavaScript testBsfJavaScript = new TestBsfJavaScript();
		bsfManager.declareBean("demo", testBsfJavaScript, TestBsfJavaScript.class);
		String content = FileUtils.readFileToString(new File(path + "/demo.cfg.js"), "utf-8");

		bsfManager.exec("javascript", path + "/demo.cfg.js", 0, 0, content);

		System.out.println(content);
		System.out.println(testBsfJavaScript.config);
	}
}
