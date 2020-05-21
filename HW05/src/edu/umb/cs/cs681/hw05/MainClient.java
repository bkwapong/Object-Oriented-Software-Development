package edu.umb.cs.cs681.hw05;

public class MainClient {
	public static void main(String[] args) {
		RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(1L, 5000000L);
		Thread t = new Thread(gen);
		long start = System.currentTimeMillis();
		
		System.out.println("For thread 1:\n");
		System.out.println("Thread started");
		
		t.start();
		
		int stopTime = 1000;
		
		while(true) {
			long stop = System.currentTimeMillis();
			if((stop - start) >= stopTime) {
				break;
			}
		}
		gen.setDone();
		
		System.out.println("Stopped generating prime nums after " + Float.toString(stopTime/1000) + " seconds");
		System.out.println(gen.primes.size() + " prime numbers are found.\n");
		try {
			t.join();
		} catch (InterruptedException e) {}
		
		
		
		RunnableCancellablePrimeGenerator gen2 = new RunnableCancellablePrimeGenerator(1L, 5000000L);
		Thread t2 = new Thread(gen2);
		start = System.currentTimeMillis();
		
		System.out.println("\nFor thread 2:\n");
		System.out.println("Thread started");
		
		t2.start();
		
		stopTime = 2000;
		
		while(true) {
			long stop = System.currentTimeMillis();
			if((stop - start) >= stopTime) {
				break;
			}
		}
		gen2.setDone();
		
		System.out.println("Stopped generating prime nums after " + Float.toString(stopTime/1000) + " seconds");
		System.out.println(gen2.primes.size() + " prime numbers are found.\n");
		try {
			t2.join();
		} catch (InterruptedException e) {}
		
		
		
		RunnableCancellablePrimeGenerator gen3 = new RunnableCancellablePrimeGenerator(1L, 5000000L);
		Thread t3 = new Thread(gen3);
		start = System.currentTimeMillis();
		
		System.out.println("\nFor thread 3:\n");
		System.out.println("Thread started");
		
		t3.start();
		
		stopTime = 3000;
		
		while(true) {
			long stop = System.currentTimeMillis();
			if((stop - start) >= stopTime) {
				break;
			}
		}
		gen3.setDone();
		
		System.out.println("Stopped generating prime nums after " + Float.toString(stopTime/1000) + " seconds");
		System.out.println(gen3.primes.size() + " prime numbers are found.\n");
		try {
			t3.join();
		} catch (InterruptedException e) {}

	}
}