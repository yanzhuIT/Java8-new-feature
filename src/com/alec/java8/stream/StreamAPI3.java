package com.alec.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import com.alec.java8.lambda.Employee;
import com.alec.java8.lambda.Employee.Status;

/*
 * stream:
 * end operation
 * 
 * */
public class StreamAPI3 {
	List<Employee> employees = Arrays.asList(new Employee("zhang", 20, 5000.1, Status.FREE),
			new Employee("wang", 30, 10000.1, Status.FREE), new Employee("lily", 30, 10000.1, Status.BUSY),
			new Employee("zhao", 30, 10000.1, Status.VOCATION), new Employee("li", 40, 20000.1, Status.BUSY),
			new Employee("Jacky", 36, 56780.0, Status.BUSY));

	@Test
	public void test1() {
		boolean b1 = employees.stream().allMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(b1);
	}

	@Test
	public void test2() {
		boolean b2 = employees.stream().anyMatch((w) -> w.getStatus().equals(Status.BUSY));
		System.out.println(b2);
	}

	@Test
	public void test3() {
		boolean b3 = employees.stream().noneMatch((q) -> q.getStatus().equals(Status.BUSY));
		System.out.println(b3);
	}

	@Test
	public void test4() {
		Optional<Employee> optional = employees.stream()
				.sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
		System.out.println(optional.get());
	}

	@Test
	public void test5() {
		Optional<Employee> optional = employees.stream().filter((e) -> e.getStatus().equals(Status.VOCATION)).findAny();
		System.out.println(optional.get());
	}

	@Test
	public void test6() {
		long count = employees.stream().count();
		System.out.println(count);

		Optional<Employee> maxSalaryEmp = employees.stream()
				.max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(maxSalaryEmp.get());

		Optional<Double> minSalary = employees.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(minSalary.get());

	}

}
