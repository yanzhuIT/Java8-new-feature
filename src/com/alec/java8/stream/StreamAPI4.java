package com.alec.java8.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.alec.java8.lambda.Employee;
import com.alec.java8.lambda.Employee.Status;

public class StreamAPI4 {

	List<Employee> employees = Arrays.asList(new Employee("zhang", 20, 5000.1, Status.FREE),
			new Employee("wang", 30, 10000.1, Status.FREE), new Employee("lily", 32, 10000.1, Status.BUSY),
			new Employee("zhao", 34, 10000.1, Status.VOCATION), new Employee("li", 40, 20000.1, Status.BUSY),
			new Employee("Jacky", 36, 56780.0, Status.BUSY));

	// map---reduce
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);
		System.out.println("------------------------------");
		Optional<Double> optional = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(optional.get());
	}

	// collect()
	@Test
	public void test2() {
		List<Integer> list = employees.stream().map(Employee::getAge).collect(Collectors.toList());
		list.forEach(System.out::println);

		System.out.println("-----------------------------------------");
		HashSet<String> hashSet = employees.stream().map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));
		hashSet.forEach(System.out::println);

		System.out.println("-----------------------------------------");
		Long sum = employees.stream().collect(Collectors.counting());
		System.out.println(sum);
	}

	// group by
	@Test
	public void test3() {
		Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
	}

	// partition
	@Test
	public void test4() {
		Map<Boolean, List<Employee>> map = employees.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000.0));
		System.out.println(map);

	}

	// summary
	@Test
	public void test5() {
		DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(dss.getAverage());
		System.out.println(dss.getSum());
		System.out.println(dss.getCount());
	}

	// join
	@Test
	public void test6() {
		String string = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
		System.out.println(string);
	}

}
