package com.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Set;
import java.util.function.Predicate;

public class DateTimeDemo {
	static String  selectedZone;
	
	public static void main(String args[]) throws InterruptedException{
		Instant start =Instant.now();
		System.out.println(start);
		
		Thread.sleep(1000);
		
		Instant end= Instant.now();
		System.out.println(end);
		
		Duration elapsed=Duration.between(start, end);
		System.out.println("Elapsed: "+elapsed);
		
	
		LocalDate currentDate=LocalDate.now();
		System.out.println(currentDate);
		
		LocalDate specificDate=LocalDate.of(2010, 1, 25);
		System.out.println(specificDate);
		
		LocalTime currentTime=LocalTime.now();
		System.out.println(currentTime);
		
		LocalTime specificTime=LocalTime.of(14, 10, 10);
		System.out.println(specificTime);
		
		LocalDateTime currentDt= LocalDateTime.now();
		System.out.println(currentDt);
		
		LocalDateTime specificDtTime =LocalDateTime.of(specificDate, specificTime);
		System.out.println(specificDtTime);
		
		
		DateTimeFormatter dateFormatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(dateFormatter.format(currentDt));
		
		DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder()
		.appendValue(ChronoField.MONTH_OF_YEAR)
		.appendLiteral("||")
		.appendValue(ChronoField.DAY_OF_MONTH)
		.appendLiteral("||")
		.appendValue(ChronoField.YEAR);
		DateTimeFormatter df= formatterBuilder.toFormatter();
		
		System.out.println(df.format(currentDt));
		
		Set<String> zones= ZoneId.getAvailableZoneIds();
		System.out.println(zones);
		Predicate<String> condition=str->str.toUpperCase().contains("Arizona".toUpperCase());
		
		
		
		zones.stream()
		.filter(condition)
		.forEach(System.out::println);
		
		zones.stream()
		.filter(condition)
		.forEach(str->selectedZone=str);
		
		ZonedDateTime zdt= ZonedDateTime.now(ZoneId.of(selectedZone));
		System.out.println(selectedZone+" :"+dateFormatter.format(zdt));
		
		
	}
	

}
