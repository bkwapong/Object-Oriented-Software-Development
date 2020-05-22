package edu.umb.cs.cs681.hw16;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	ConcurrentHashMap <java.nio.file.Path, AtomicInteger> hashMap = new ConcurrentHashMap <java.nio.file.Path, AtomicInteger>();
	
	private static ReentrantLock staticLock = new ReentrantLock();
	
	private static AccessCounter instance = null;
	
	private AccessCounter(){}
	
	
	public static AccessCounter getInstance()
	{
		staticLock.lock();
		try {
			if(instance==null)
			{
				instance = new AccessCounter();
			}
		} finally {
			staticLock.unlock();
		}
		return instance;
	}

	public void increment(java.nio.file.Path path)
	{
		hashMap.compute(path, (java.nio.file.Path k, AtomicInteger v) -> {
			if(v == null) {
				System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + 1);
				return new AtomicInteger(1);
			} else {
				System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + (v.get()+1));
				return new AtomicInteger(v.incrementAndGet());
			}
		});
	}

	public int getCount(java.nio.file.Path path)
	{
		return hashMap.compute(path, (java.nio.file.Path k, AtomicInteger v) -> {
			if(v == null) {
				System.out.println(Thread.currentThread().getName() + " get " + path + " count " + 0);
				return new AtomicInteger(0);
			} else {
				System.out.println(Thread.currentThread().getName() + " get " + path + " count " + v.get());
				return v;
			}
		}).get();
	}

	public static void main(String[] args) {
		
		Thread[] threads = new Thread[20];
		RequestHandler[] requestHandlers = new RequestHandler[20];


		for (int i = 0; i < 20; i++) {
			System.out.println("Start Thread " + i);
			requestHandlers[i] = new RequestHandler(i);
			threads[i] = new Thread(requestHandlers[i]);
			threads[i].start();
		}

		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " " + e);
		}
		for(int i = 0; i < 20; i++) {
			requestHandlers[i].setDone();
			threads[i].interrupt();
			try {
				threads[i].join();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
