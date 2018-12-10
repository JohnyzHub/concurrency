package com.myjava.concurrency.queue.synchronous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @author johnybasha
 *
 */
public class TestSynchronousQueue {

	public static void main(String[] args) {

		SynchronousQueue<String> dataQueue = new SynchronousQueue<>();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new DataProducer(dataQueue));
		executorService.submit(new DataConsumer(dataQueue));

		executorService.shutdown();


	}

}
