package com.softel.model.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeVo {
	
	private final static Calendar calendar = Calendar.getInstance();
	
	private final static SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	private String date;
	
	private Integer year;
	
	private Integer month;
	
	private Integer day;
	
	private Integer hour;
	
	private Integer minute;
	
	private Integer second;
	
	private Integer millsecond;
	
	public TimeVo(){
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH) + 1;
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.date = simpleFormat.format(calendar.getTime());
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		this.millsecond = calendar.get(Calendar.MILLISECOND);
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	public Integer getMillsecond() {
		return millsecond;
	}

	public void setMillsecond(Integer millsecond) {
		this.millsecond = millsecond;
	}

}
