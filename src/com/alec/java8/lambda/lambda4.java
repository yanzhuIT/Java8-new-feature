package com.alec.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 *  java 8 build-in functional interface
 *  
 *  1. Consumer<T>:
 *  	void accept(T t);
 *  
 *  2. Supplier<T>:
 *  	T get();
 *  
 *  3. Function<T, R>:
 *  	R apply(T);
 *  
 *  4. Predicate<T>:
 *  	boolean test(T t);
 *  
 *  
 *  
*/
public class lambda4 {
	// 1
	@Test
	public void test1() {
		happy(10000, (money) -> System.out.println("Every time is " + money + "."));
	}

	public void happy(double money, Consumer<Double> consumer) {
		consumer.accept(money);
	}

	// 2
	@Test
	public void test2() {
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer integer : numList) {
			System.out.println(integer);
		}
	}

	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer xInteger = sup.get();
			list.add(xInteger);
		}
		return list;
	}

	// 3
	@Test
	public void test3() {
		String upperCase = strHandler("i like coding.", (str) -> str.toUpperCase());
		System.out.println(upperCase);

		String subString = strHandler("i like coding", (str) -> str.substring(0, 5));
		System.out.println(subString);
	}

	public String strHandler(String str, Function<String, String> function) {
		return function.apply(str);
	}

	// 4
	@Test
	public void test4() {
		List<String> list = Arrays.asList("hello", "www", "Alec", "java");

		List<String> newList = filterStr(list, (str) -> str.length() > 3);
		for (String str : newList) {
			System.out.println(str);
		}

	}

	public List<String> filterStr(List<String> list, Predicate<String> predicate) {
		List<String> strList = new ArrayList<>();
		for (String str : list) {
			if (predicate.test(str)) {
				strList.add(str);
			}
		}
		return strList;
	}

}
