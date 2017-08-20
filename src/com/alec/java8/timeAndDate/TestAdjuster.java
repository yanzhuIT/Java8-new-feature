package com.alec.java8.timeAndDate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestAdjuster {

	@Test
	public void test1() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println("------------");
		LocalDateTime ldt2 = ldt.withDayOfMonth(21);
		System.out.println(ldt2);
		System.out.println("----------------");
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println(ldt3);
	}

}
