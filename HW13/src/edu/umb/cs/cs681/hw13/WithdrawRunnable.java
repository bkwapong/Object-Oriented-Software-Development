package edu.umb.cs.cs681.hw13;

import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable {

	private ThreadSafeBankAccount bankAccount = null;
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public WithdrawRunnable(ThreadSafeBankAccount bankAccount) {
		this.bankAccount = bankAccount;
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
		while (true) {
			lock.lock();
			try{
				if (done) {
					System.out.println("Thread " + Thread.currentThread().getId() + " Set to done");
					break;
				}
			} finally {
				lock.unlock();
			}
			bankAccount.withdraw(100);
			try{
				Thread.sleep(1000);
			} catch (InterruptedException exception) {
				System.out.println(exception);
				continue;
			}
		}
	}
}
