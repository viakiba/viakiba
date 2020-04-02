package com.company.hotreload;

import java.lang.instrument.ClassDefinition;

public class HotReloadService  {
	private static HotReloadService instance = new HotReloadService();
	public static HotReloadService getInstance() {
		return instance;
	}
	public void hotReload(HotReloadClassData msg) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(msg.getClassName());
		} catch (Exception e) {
			System.err.println("HotReload class not found:" + msg.getClassName());
			return;
		}
		String result = launch(clazz,msg.getData());
		System.out.println(result);
	}
	public String launch(Class<?> clazz,byte[] data) {
		try {
			InstrumentationHolder.getInstrumentation()
					.redefineClasses(new ClassDefinition(clazz, data));
		} catch (Throwable th) {
			th.printStackTrace();
			return "fail-classname=" + clazz.getName();
		}
		return "classname=" + clazz.getName() + " HotReload success";
	}
}
