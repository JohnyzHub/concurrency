package com.myjava.concurrency.queue.blocking;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author johnybasha
 *
 */
public class DataProducer implements Runnable {
	
	private BlockingQueue<String> dataQueue;
	
	public DataProducer(BlockingQueue<String> dataQueue) {
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			String data = UUID.randomUUID().toString();
		System.out.println("Producing data-"+data);
		try {
			dataQueue.put(data);
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}

	}
	

}
