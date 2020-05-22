package edu.umb.cs.cs681.hw07;

import java.util.concurrent.locks.ReentrantLock;

public class AutoSaver extends File implements Runnable {

	private boolean done = false;
	private File file;
	private ReentrantLock lock = new ReentrantLock();
	
	public AutoSaver(File file) {
		this.file = file;
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}finally {
			lock.unlock();
		}
	}
	
	public void run() {
		while(true) {
			if(done) {
				break;
			}
			try {
				System.out.println("AutoSaver called save()");
				save();
				System.out.println("AutoSaver sleeps for 2 secs...");
				Thread.sleep(2000);
			}catch (InterruptedException e) {}
		}
	}
}
