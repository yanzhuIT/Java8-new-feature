package com.alec.java8.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;

/*
 * -----method reference
 * 1.object::instance method
 * 
 * 2.class::static method
 * 
 * 3.class::instance method
 * 
 * Note: For 1 and 2, return type and argument list in lambda must be the same 
 * as these items of abstract method in functional interface.
 * 
 * Note: For 3, the first argument is invoker, the second argument is method argument.
 * 
 * 
 * ------constructor reference
 * class::new
 * 
 * 
 * ------array reference
 * type::new
 * 
 */
public class MethodRef {
	// 1
	@Test
	public void test1() {
		Employee employee = new Employee("zhu", 38, 3000.5);
		Supplier<String> supplier = () -> employee.getName();
		String string = supplier.get();
		System.out.println(string);
		// if there is a completed method in lambda body, lambda expression could be
		// written like below
		Supplier<Integer> supplier2 = employee::getAge;
		Integer age = supplier2.get();
		System.out.println(age);
	}

	// 2
	@Test
	public void test2() {
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		int result = comparator.compare(100, 200);
		System.out.println(result);
		// apply the second writing
		Comparator<Integer> comparator2 = Integer::compare;
		int result2 = comparator2.compare(100, 200);
		System.out.println(result2);

	}

	// 3
	@Test
	public void test3() {
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		boolean b = bp.test("I", "i");
		System.out.println(b);

		// apply the third writing
		BiPredicate<String, String> bp2 = String::equals;
		boolean b2 = bp2.test("you", "you");
		System.out.println(b2);

	}

	// constructor reference--- old writing
	@Test
	public void test4() {
		Supplier<Employee> supplier = () -> new Employee("zhang", 40, 345.6);
		Employee employee = supplier.get();
		System.out.println(employee);
	}

	// constructor reference---new writing
	@Test
	public void test5() {
		// here integer should be the age according to the constructor define.
		Function<Integer, Employee> function = Employee::new;
		Employee employee = function.apply(20);
		System.out.println(employee);

		// for two para for Employee, there must be a constructor for lambda
		BiFunction<String, Integer, Employee> function2 = Employee::new;
		Employee employee2 = function2.apply("Alec", 20);
		System.out.println(employee2);
	}

	// array reference
	@Test
	public void test6() {
		Function<Integer, String[]> function = (x) -> new String[x];
		String[] strings = function.apply(10);
		System.out.println(strings.length);
		// apply new writing
		Function<Integer, String[]> function2 = String[]::new;
		String[] strings2 = function2.apply(10000);
		System.out.println(strings2.length);

	}

}
