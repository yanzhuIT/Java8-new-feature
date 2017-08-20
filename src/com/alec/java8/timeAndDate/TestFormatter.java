package com.alec.java8.timeAndDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestFormatter {

	@Test
	public void test1() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt = LocalDateTime.now();
		String strDate = ldt.format(dtf);
		System.out.println(strDate);
		System.out.println("----------------------");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy:MM:dd:hh:mm:ss");
		String strDateTime = dtf2.format(ldt);
		System.out.println(strDateTime);
	}
	
}
