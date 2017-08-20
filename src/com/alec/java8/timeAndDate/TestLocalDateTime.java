package com.alec.java8.timeAndDate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import org.junit.Test;

// ISO8601----multiple thread 
public class TestLocalDateTime {
	// local
	@Test
	public void test1() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		System.out.println("--------------------");
		LocalDateTime localDateTime2 = LocalDateTime.of(2017, 8, 19, 10, 34);
		System.out.println(localDateTime2);
		System.out.println("--------------------");
		LocalDateTime localDateTime3 = localDateTime.plusYears(2);
		System.out.println(localDateTime3);
		System.out.println("---------------------");
		System.out.println(localDateTime.getYear());
		System.out.println(localDateTime.getDayOfMonth());
		System.out.println(localDateTime.getHour());
	}

	// instant: timestamp----1970.01.01.00:00:00
	@Test
	public void test2() {
		Instant instant = Instant.now(); // UTC time zone
		System.out.println(instant);
		System.out.println("-------------------");
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(-4));
		System.out.println(offsetDateTime);

	}
	
	// duration-----time
	@Test
	public void test3() throws InterruptedException {
		Instant instant = Instant.now();
		Thread.sleep(1000);
		Instant instant2 = Instant.now();
		System.out.println(Duration.between(instant, instant2).toMillis());
		System.out.println("---------------------");
		LocalTime localTime = LocalTime.now();
		Thread.sleep(1000);
		LocalTime localTime2 = LocalTime.now();
		System.out.println(Duration.between(localTime, localTime2).getSeconds());
	}
	
	// period-------date
	@Test
	public void test4() {
		LocalDate localDate = LocalDate.of(2015, 1, 1);
		LocalDate localDate2 = LocalDate.now();
		Period period = Period.between(localDate, localDate2);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
	}

}
