package com.alec.java8.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {

	@Test
	public void test1() {
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
	}

	// new java8 parallel
	@Test
	public void test2() {
		long sum = LongStream.rangeClosed(0, 100000000L).parallel().reduce(0, Long::sum);
		System.out.println(sum);

	}

}
