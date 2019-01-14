package com.myjava.concurrency.utilities.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @author johnybasha
 *
 */
public class TestForkJoin {

	public static void main(String[] args) {

		RandomNumberTask task = new RandomNumberTask(4);
		ForkJoinPool pool = new ForkJoinPool();
		long sum = pool.invoke(task);

		System.out.println("Sum of the numbers: " + sum);
	}
}