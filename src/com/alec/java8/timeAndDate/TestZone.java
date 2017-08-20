package com.alec.java8.timeAndDate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

import org.junit.Test;

public class TestZone {
	
	@Test
	public void test1() {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Monaco"));
		System.out.println(ldt);
	}

}
