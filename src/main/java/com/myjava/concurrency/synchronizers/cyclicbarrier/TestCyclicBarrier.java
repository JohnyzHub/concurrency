package com.myjava.concurrency.synchronizers.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	public static void main(String[] args) {

		int[] params = new int[] { 2, 4 };
		Computation comp1 = new Computation(params[0]);
		Computation comp2 = new Computation(params[1]);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
			int result = comp1.getResult() + comp2.getResult();
			System.out.println(String.format("The sum of square root of %s and square root of %s is : %s", params[0],
					params[1], result));

		});

		comp1.setBarrier(cyclicBarrier);
		comp2.setBarrier(cyclicBarrier);

		Thread t1 = new Thread(comp1, "T1");
		Thread t2 = new Thread(comp2, "T2");

		t1.start();
		t2.start();

		try {
			System.out.println(String.format("%s is waiting for other threads", Thread.currentThread().getName()));
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("%s is Finsihed.", Thread.currentThread().getName()));
	}

}
