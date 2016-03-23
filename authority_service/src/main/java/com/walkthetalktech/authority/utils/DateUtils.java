package com.walkthetalktech.authority.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat();
	
	private static Calendar calendar=Calendar.getInstance();
	
	public synchronized  static Calendar getCurrentCalendar(){
		if(null==calendar){
			calendar=Calendar.getInstance();
		}
		return calendar;
	}
	
	public static String getCurrentTime(String pattern){
		sdf.applyPattern(pattern);
		return sdf.format(calendar.getTime());
	}
	
	public static Integer getCurrentMonthNumber(){
		return calendar.get(Calendar.MONTH)+1;
	}
	
	public static String getCurrentMonth(){
		switch(calendar.get(Calendar.MONTH)){
		case Calendar.JANUARY:
			return "一月";
		case Calendar.FEBRUARY:
			return "二月";
		case Calendar.MARCH:
			return "三月";
		case Calendar.APRIL:
			return "四月";
		case Calendar.MAY:
			return "五月";
		case Calendar.JUNE:
			return "六月";
		case Calendar.JULY:
			return "七月";
		case Calendar.AUGUST:
			return "八月";
		case Calendar.SEPTEMBER:
			return "九月";
		case Calendar.OCTOBER:
			return "十月";
		case Calendar.NOVEMBER:
			return "十一月";
		case Calendar.DECEMBER:
			return "十二月";
			default:
				return "出现错误";
		}
	}
	
	/*public static void main(String[] args) {
		System.out.println(DateUtils.getCurrentMonthNumber());
	}*/
	
}
