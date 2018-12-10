package com.myjava.concurrency.lock.lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.myjava.concurrency.utilities.threadfactory.ThreadFactoryBuilder;

/**
 * @author johnybasha
 *
 */
public class TestReentrantLock {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("BANANA", "APPLE", "ORANGE");

		ReadWriteTask task = new ReadWriteTask();

		ThreadFactory threadFactory = new ThreadFactoryBuilder().setName("Thread").build();

		ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);

		Runnable writeTask = () -> fruits.forEach(a -> {
			task.writeData(a);
		});

		Runnable readTask = () -> {
			int size = fruits.size();
			for (int index = 0; index < size; index++) {
				task.readData();
			}
		};

		executorService.submit(readTask);
		executorService.submit(writeTask);
	}

}
