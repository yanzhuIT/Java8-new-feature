package com.alec.java8.parallel;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long start;
	private long end;
	private static final long THRESHOLD = 10000;

	public ForkJoinCalculate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		long middle = (start + end) / 2;
		if (length <= THRESHOLD) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork(); // fork into subtask

			ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
			right.fork();
			return left.join() + right.join();
		}
	}
}
