package com.myjava.concurrency.queue.transfer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author johnybasha
 *
 */
public class TestTransferQueue {

	public static void main(String[] args) {

		TransferQueue<String> dataQueue = new LinkedTransferQueue<>();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new DataProducer(dataQueue));
		executorService.submit(new DataConsumer(dataQueue));
		executorService.submit(new DataConsumer(dataQueue));

		executorService.shutdown();
	}

}
