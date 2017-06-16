package com.hrmsys.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 序列号生成器
 * @author Administrator
 *
 */
public class SequenceBuilder {
	/**
	 * 获取序列号 = 年份+日期+小时+分钟+四位随机数
	 */
	public static String getSequence(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		String months = null;
		String days = null;
		String hours = null;
		String minues = null;
		String subfixs = null;
		int month = calendar.get(Calendar.MONTH)+1;
		if(month < 10){
			months = "0"+month;
		}else{
			months = ""+month;
		}
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if(day < 10){
			days = "0"+day;
		}else{
			days = ""+day;
		}
		int hour = new Date().getHours();
		if(hour < 10){
			hours = "0"+hour;
		}else{
			hours = ""+hour;
		}
		int minue = new Date().getMinutes();
		if(minue < 10){
			minues = "0"+minue;
		}else{
			minues = ""+minue;
		}
		String subfix = ""+(int)(Math.random()*1000);
		if(subfix.length() < 4){
			subfix = subfix+10000;
			subfix = subfix.substring(1, 5);
		}
		String sequence = ""+year+months+days+hours+minues+subfix;
		return sequence;
	}
	
	public static void main(String[] args){
		System.out.println(getSequence());
	}
}
