package com.alec.java8.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class lambda2 {
	// 1.no argument, no return value.
	@Test
	public void test1() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};
		runnable.run();

		System.out.println("-----------------------------");
		Runnable runnable2 = () -> System.out.println("Hello Lambda!");
		runnable2.run();
	}

	// 2.one argument, no return value.
	@Test
	public void test2() {
		Consumer<String> consumer = (x) -> System.out.println(x);
		// if only one argument, the parentheses can not exist.
		// Consumer<String> consumer = x -> System.out.println(x);
		consumer.accept("I hate my stupid.");
	}

	// 3.Multiple arguments, return value, more than one instrument
	@Test
	public void test3() {
		Comparator<Integer> comparator = (x, y) -> {
			System.out.println("test multiple instruments!");
			return Integer.compare(x, y);
		};
		System.out.println(comparator.compare(3, 5));
	}

	@Test
	public void test4() {
		Integer num = operation(100, (x) -> x * x);
		System.out.println(num);

	}
	public Integer operation(Integer num, MyFun mFun) {
		return mFun.getValue(num);
	}

}
