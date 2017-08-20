package com.alec.java8.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class lambda1 {

	List<Employee> employees = Arrays.asList(new Employee("zhang", 20, 5000.1), new Employee("wang", 30, 10000.1),
			new Employee("li", 40, 20000.1));

	@Test
	public void test2() {
		employees.stream().filter((e) -> e.getSalary() <= 20000).limit(1).forEach(System.out::println);

	}

}
