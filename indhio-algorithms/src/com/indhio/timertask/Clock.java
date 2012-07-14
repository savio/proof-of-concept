package com.indhio.timertask;


public class Clock implements Runnable {

	private Thread turbo = null;

	public void start() {
		if (turbo == null) {
			turbo = new Thread(this, "Clock");
			turbo.start();
		}
	}

	public void run() {
		Thread myThread = Thread.currentThread();
		while (turbo == myThread) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// the VM doesn't want us to sleep anymore,
				// so get back to work
			}
		}
	}

	// overrides Applet's stop method, not Thread's
	public void stop() {
		turbo = null;
	}
}
