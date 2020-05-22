package edu.umb.cs.cs681.hw08;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable{
	private ConcurrentSingleton() {};
	private static ConcurrentSingleton instance = null;
	private static ReentrantLock lock = new ReentrantLock();
	
	public static ConcurrentSingleton getInstance() {
		lock.lock();
		try {
			if(instance == null) {
				instance = new ConcurrentSingleton();
				System.out.println("ConcurrentSingleton instance created!");
			}
		}finally {
			lock.unlock();
		}
		return instance;
	}

	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " starting...");
		ConcurrentSingleton cs = new ConcurrentSingleton();
		System.out.println("Running instance: " + cs.getInstance());
		System.out.println("Thread " + Thread.currentThread().getId() + " ending...");
	}
	
	public static void main(String[] args) {
		Thread T1 = new Thread(new ConcurrentSingleton());
		Thread T2 = new Thread(new ConcurrentSingleton());
		Thread T3 = new Thread(new ConcurrentSingleton());
		Thread T4 = new Thread(new ConcurrentSingleton());
		Thread T5 = new Thread(new ConcurrentSingleton());
		Thread T6 = new Thread(new ConcurrentSingleton());
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
		T6.start();
		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
			T5.join();
			T6.join();
		} catch (InterruptedException error) {
			error.printStackTrace();
		}
	}
}
