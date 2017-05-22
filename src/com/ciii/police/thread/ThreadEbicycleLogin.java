package com.ciii.police.thread;

public final class ThreadEbicycleLogin implements Runnable {
	private Thread t;
	
	private String threadName;
	   
	/**
	 * 
	 */
	public ThreadEbicycleLogin( String name) {
		threadName = name;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		//
	}

	/**
	 * 
	 */
	public void start () {
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
		}
	}
}
