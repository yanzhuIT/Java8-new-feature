package com.alec.java8.optional;

import java.util.Optional;

import org.junit.Test;

import com.alec.java8.lambda.Employee;
import com.alec.java8.lambda.Employee.Status;

// solve null-pointer problem
public class TestOptional {

	@Test
	public void test1() {
		Optional<Employee> op = Optional.of(new Employee());
		System.out.println(op.get());
	}

	@Test
	public void test2() {
		Optional<Employee> optional = Optional.ofNullable(null);
		Employee employee = optional.orElse(new Employee("zhang", 88, 888.88, Status.BUSY));
		System.out.println(employee);
	}

	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable(new Employee("zhang", 88, 888.88, Status.BUSY));
		Optional<String> name = op.map((e) -> e.getName());
		System.out.println(name.get());
	}

}
