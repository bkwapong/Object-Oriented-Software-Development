package edu.umb.cs.cs681.hw07;

import java.util.concurrent.locks.ReentrantLock;

public class Editor extends File implements Runnable {
	
	private File file;
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	
	public Editor(File file) {
		this.file = file;
	}

	public void run() {
		while(true) {
			try {
				if(done) {
					break;
				}
				System.out.println("Editor called change");
				file.change();
				System.out.println("Editor called save");
				file.save();
				System.out.println("Editor sleeps for 1 sec...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}finally {
			lock.unlock();
		}
	}

}
