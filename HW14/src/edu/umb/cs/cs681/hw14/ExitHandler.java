package edu.umb.cs.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable {

	private AdmissionControl control;
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;


	public ExitHandler(AdmissionControl control) {
		this.control = control;
	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}


	public void run() {
		while(true) {
			lock.lock();
			try {
				if(done) {
					System.out.println("ExitHandler set to done");
					break;
				}
			}
			 finally {
				lock.unlock();
			}
			control.exit();
			try{
				Thread.sleep(150);
			} catch(InterruptedException e) {
				System.out.println(e);
				continue;
			} 
		}
	}

}
