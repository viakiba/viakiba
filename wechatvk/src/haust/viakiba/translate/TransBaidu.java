package haust.viakiba.translate;

/**
 * 直接运行main方法即可输出翻译结果
 */
public class TransBaidu {
	
	
	public static String tranBd(String str) throws Exception {
		//source   翻译的内容
		String source = str.substring(2);
		//翻译的目标语言
		char target = str.charAt(1);
		//执行翻译
		String result = TranslateUtil.translateToEn(source,target);
		
		if(result == null){
			System.out.println("翻译出错，参考百度错误代码和说明。");
			return "无法翻译";
		}
		return source+"===>"+result;
	}
}
