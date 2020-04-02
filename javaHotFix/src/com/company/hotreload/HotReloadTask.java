package com.company.hotreload;

import javax.tools.*;
import javax.tools.JavaFileObject.Kind;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;

public class HotReloadTask {
	public static final String GS_DEPLOY_CONTEXT_CLASSPATH_DIR = "C:\\Users\\89264\\Desktop\\";

	/**
	 * 编译使用的-classpath的值
	 */
	private volatile String compileClassPath;

	public List<HotReloadClassData> hotreloadClassData;

	/**
	 * 全路径的类名 与 全文件字符串
	 */
	private Map<String, String> name2Codes;

	/**
	 * 编译结果
	 */
	private List<JavaClassFileObject> compiledClassObjects;

	public HotReloadTask(Map<String, String> name2Codes) {
		this.name2Codes = name2Codes;
	}

	public void run() {
		try {
			System.out.println(" -任务开始...");
			if (compile()) {
				hotreloadClassData = new ArrayList<>();
				for (JavaClassFileObject classObject : compiledClassObjects) {
					HotReloadClassData hotreloadClassData = new HotReloadClassData();
					hotreloadClassData.setClassName(classObject.name);
					hotreloadClassData.setData(classObject.getClassData());
					this.hotreloadClassData.add(hotreloadClassData);
				}
			}
		} catch (Throwable th) {
			th.printStackTrace();
		} finally {
			System.out.println("任务结束！");
		}
	}


	private boolean compile() throws Exception {
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		if (jc == null) {
			throw new Exception("获得系统的java编译器失败！请检查指定的java环境下的lib目录是否缺少tools.jar");
		}
		DiagnosticCollector<JavaFileObject> dc = new DiagnosticCollector<>();
		FileManagerImpl fileManager = new FileManagerImpl(jc.getStandardFileManager(dc, null, null));
		if (!jc.getTask(null, fileManager, dc, getCompileOptions(), null, getJavaSourceFileObjectsFromCodes()).call()) {
			System.out.println(">>>>>>>>>>>>>"+"编译错误");
			return false;
		}
		compiledClassObjects = fileManager.classObjects;
		return true;
	}

	private List<JavaSourceFileObject> getJavaSourceFileObjectsFromCodes() {
		List<JavaSourceFileObject> res = new ArrayList<>();
		for (Entry<String, String> name2Code : name2Codes.entrySet()) {
			try {
				res.add(new JavaSourceFileObject(name2Code.getKey(), name2Code.getValue()));
			} catch (URISyntaxException e) {
				throw new IllegalArgumentException("全路径类名非法，无法创建uri- " + name2Code.getKey(), e);
			}
		}
		return res;
	}

	private Iterable<String> getCompileOptions() {
		return Arrays.asList("-classpath", getCompileClassPath());
	}

	public String getCompileClassPath() {
		// 其实线程池用的单个线程，这里这么写只是有趣
		if (compileClassPath == null) {
			if (compileClassPath == null) {
				StringBuilder sb = new StringBuilder();
				try {
					File dir = new File(GS_DEPLOY_CONTEXT_CLASSPATH_DIR);
					for (String fileName : dir.list()) {
						if (fileName.endsWith(".jar")) {
							sb.append(GS_DEPLOY_CONTEXT_CLASSPATH_DIR).append(fileName).append(File.pathSeparatorChar);
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("编译使用的-classpath的值初始化失败！", e);
				}
				if (sb.length() > 1) {
					sb.delete(sb.length() - 1, sb.length());
					compileClassPath = sb.toString();
				}
			}
		}
		return compileClassPath;
	}

	private class JavaSourceFileObject extends SimpleJavaFileObject {
		
		String code;

		public JavaSourceFileObject(String name, String code) throws URISyntaxException {
			super(new URI("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.code = code;
		}
		
		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			return code;
		}
		
	}
	
	private class JavaClassFileObject extends SimpleJavaFileObject {
		
		String name;
		
		ByteArrayOutputStream byteCode;

		public JavaClassFileObject(String name) throws URISyntaxException {
			super(new URI("bytearr:///" + name.replace('.','/') + Kind.CLASS.extension), Kind.CLASS);
			this.name = name;
		}
		
		@Override
		public OutputStream openOutputStream() throws IOException {
			byteCode = new ByteArrayOutputStream();
			return byteCode;
		}
		
		public byte[] getClassData() {
			return byteCode.toByteArray();
		}
		
	}
	
	private class FileManagerImpl extends ForwardingJavaFileManager<JavaFileManager> {
		
		List<JavaClassFileObject> classObjects;
		
		public FileManagerImpl(JavaFileManager fileManager) {
			super(fileManager);
			classObjects = new ArrayList<>();
		}
		
		@Override
		public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
				throws IOException {
			try {
				JavaClassFileObject classObject = new JavaClassFileObject(className);
				classObjects.add(classObject);
				return classObject;
			} catch (URISyntaxException e) {
				throw new IllegalArgumentException("编译成功后的类名，无法转为URI：" + className, e);
			}
		}
		
	}

}
