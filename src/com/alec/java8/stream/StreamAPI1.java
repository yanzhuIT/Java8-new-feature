package com.alec.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;
import com.alec.java8.lambda.Employee;

public class StreamAPI1 {

	// create a stream
	@SuppressWarnings("unused")
	@Test
	public void test1() {
		// 1.Collection's stream().
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();

		// 2.Arrays' static stream().
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);

		// 3.Stream's of()
		Stream<String> stream3 = Stream.of("John", "Lily", "Alec", "Hebe");

		// 4.infinite stream
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
		stream4.limit(10).forEach(System.out::println);
	}

}
