package com.company.hotreload;

/**
 * 来自gm，热更的类的字节码数据的消息
 * @author yuhao
 *
 */
public class HotReloadClassData {

	/**
	 * 全路径类名
	 */
	private String className;
	
	/**
	 * 类字节码数据
	 */
	private byte[] data;


	public String getClassName() {
		return className;
	}

	public byte[] getData() {
		return data;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
