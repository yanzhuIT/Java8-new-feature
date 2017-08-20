package com.alec.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class lambda3 {

	List<Employee> employees = Arrays.asList(new Employee("zhang", 20, 5000.1), new Employee("wang", 30, 10000.1),
			new Employee("li", 40, 20000.1), new Employee("zhao", 25, 39000.1), new Employee("liu", 38, 50000.2));

	@Test
	public void test1() {
		Collections.sort(employees, (e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());

			} else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void test2() {
		String uppercase = strHandler("my favorite java.", (str) -> str.toUpperCase());
		System.out.println(uppercase);
	}

	public String strHandler(String str, Myfunc2 myfunc2) {
		return myfunc2.getVaule(str);
	}

	@Test
	public void test3() {
		opera(100l, 200l, (x, y) -> x + y);
		opera(100l, 200l, (x, y) -> x * y);
	}

	public void opera(Long l1, Long l2, MyFunc3<Long, Long> myFunc3) {
		System.out.println(myFunc3.getValue(l1, l2));
	}

}
