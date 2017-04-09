package com.training.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeExamples {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2014, 2, 15); // 2014-06-15
		boolean isBefore = LocalDate.now().isBefore(date); // false
		// information about the month
		Month february = date.getMonth(); // FEBRUARY
		int februaryIntValue = february.getValue(); // 2
		int minLength = february.minLength(); // 28
		int maxLength = february.maxLength(); // 29
		Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY
		// information about the year
		int year = date.getYear(); // 2014
		int dayOfYear = date.getDayOfYear(); // 46
		int lengthOfYear = date.lengthOfYear(); // 365
		boolean isLeapYear = date.isLeapYear(); // false
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
		String dayOfWeekName = dayOfWeek.name(); // SATURDAY
		int dayOfMonth = date.getDayOfMonth(); // 15
		LocalDateTime startOfDay = date.atStartOfDay(); // 2014-02-15 00:00
		// time information
		LocalTime time = LocalTime.of(15, 30); // 15:30:00
		int hour = time.getHour(); // 15
		int second = time.getSecond(); // 0
		int minute = time.getMinute(); // 30
		int secondOfDay = time.toSecondOfDay(); // 55800
		
	}

}
