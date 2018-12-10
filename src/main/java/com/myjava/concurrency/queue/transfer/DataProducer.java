package com.myjava.concurrency.queue.transfer;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author johnybasha
 *
 */
public class DataProducer implements Runnable {

	private TransferQueue<String> dataQueue;

	public DataProducer(TransferQueue<String> dataQueue) {
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String data = UUID.randomUUID().toString();
			System.out.println("Producing data-" + data);
			try {
				dataQueue.transfer(data);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
