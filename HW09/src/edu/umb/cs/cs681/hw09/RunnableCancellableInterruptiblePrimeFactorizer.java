package edu.umb.cs.cs681.hw09;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{
	
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}finally {
			lock.unlock();
		}
	}
	
	public void generatePrimeFactors() {
		long divisor = 2;
	    while( dividend != 1 && divisor <= to ){
	    	lock.lock();
	    	try {
	    		if(done) {
					System.out.println("Stopped prime factorization...");
	    			break;
				}
			    if(dividend % divisor == 0) {
			        factors.add(divisor);
			        dividend /= divisor;
			    }else {
			    	if(divisor==2){ divisor++; }
			    	else{ divisor += 2; }
			    	
			    }
	    	}finally {
	    		lock.unlock();
			}
			try {
				System.out.println("factorizer thread sleep for 0.2s");
				Thread.sleep(200);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
				System.out.println(e.toString());
				continue;
			}

		}
	}
	
	public static void main(String[] args) {
		System.out.println("Prime factorization of 105, and interrupt immediately");
		RunnableCancellableInterruptiblePrimeFactorizer factorizer = new RunnableCancellableInterruptiblePrimeFactorizer(105, 2, 30);
		Thread thread1 = new Thread(factorizer);
		Thread thread2 = new Thread(factorizer);
		thread1.start();
		thread2.start();
		try {
			System.out.println("main thread sleep for 1sec.");
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(e.toString());
		
		factorizer.setDone();
		thread1.interrupt();
		thread2.interrupt();
		}try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Prime factors found: " + factorizer.getPrimeFactors() + "\n");
	}
}


