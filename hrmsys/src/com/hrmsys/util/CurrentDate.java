package com.hrmsys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDate {
	/**
	 * 返回字符串形式的日期
	 * @return
	 */
	public static String getStringDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * 返回日期的字符串格式
	 * @param date
	 * @return string
	 */
	public static String getStringDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * 返回日期类型的日期
	 * @return Date类型
	 */
	public static Date getDate(){
		Date date = new Date();
		Date newDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 newDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	/**
	 * 返回日期类型的日期和时间
	 * @return Date类型
	 */
	public static Date getDateAndTime(){
		Date date = new Date();
		Date newDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			 newDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	/**
	 * 返回日期类型的日期和时间
	 * @return Date类型
	 */
	public static String getStringDateAndTime(){
		Date date = new Date();
		String newDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		newDate = sdf.format(date);
		return newDate;
	}
	
	public static String getDateWeek(){
		String[] week = new String[]{"日","一","二","三","四","五","六"};
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = new Date();
		String dateString = sdf.format(date);
		Calendar calendar = Calendar.getInstance();
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekDay);
		return dateString+" 星期"+week[weekDay-1];
	}
	
	public static void main(String[] args){
		System.out.println(CurrentDate.getStringDateAndTime());;
	}
}
	
