package com.example.solution.amqp.receiver;

import java.util.concurrent.CountDownLatch;

public class UnsccessfulMessageConsumer {
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		System.out.println("Damn! Received <" + message + ">");
	    latch.countDown();
	}

	public CountDownLatch getLatch() {
	    return latch;
	}

}
