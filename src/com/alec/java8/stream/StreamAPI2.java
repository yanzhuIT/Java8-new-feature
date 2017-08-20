package com.alec.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;
import com.alec.java8.lambda.Employee;

public class StreamAPI2 {
	List<Employee> employees = Arrays.asList(new Employee("zhang", 20, 5000.1), new Employee("wang", 30, 10000.1),
			new Employee("wang", 30, 10000.1), new Employee("wang", 30, 10000.1), new Employee("li", 40, 20000.1));

	@Test
	public void test1() {
		// middle operation
		// filter()
		Stream<Employee> stream = employees.stream().filter((e) -> e.getAge() > 35);
		// end operation
		stream.forEach(System.out::println);
	}

	@Test
	public void test2() {
		// limit()
		employees.stream().filter((e) -> e.getSalary() > 10000.0).limit(1).forEach(System.out::println);
	}

	@Test
	public void test3() {
		// skip()
		employees.stream().filter((e) -> e.getAge() <= 40).skip(2).forEach(System.out::println);
	}

	@Test
	public void test4() {
		// distinct() based on hashcode() and equals()
		employees.stream().distinct().forEach(System.out::println);
	}

	@Test
	public void test5() {
		List<String> list = Arrays.asList("i", "love", "you");
		// map(), for every para, to do method once
		list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
		System.out.println("------------------------");
		employees.stream().map(Employee::getName).forEach(System.out::println);
	}

	@Test
	public void test6() {
		List<String> list = Arrays.asList("i", "love", "you", "May");
		// sorted()
		list.stream().sorted().forEach(System.out::println);
		System.out.println("-------------------------------");
		employees.stream().sorted((e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			} else {
				return -e1.getAge().compareTo(e2.getAge());
			}
		}).forEach(System.out::println);
	}

}
