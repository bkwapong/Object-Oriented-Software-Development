package edu.umb.cs.cs681.hw21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;


public class CallablePrimeGenerator extends PrimeGenerator implements Callable<LinkedList<Long>> {
	
	public CallablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public static void main(String[] args) {
		
		long start_Time = System.currentTimeMillis();
		
		LinkedList<Long> allPrimes = new LinkedList<>();
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ExecutorCompletionService<LinkedList<Long>> completionService = new ExecutorCompletionService<>(executor);
		
		long lowerLimit = 1L;
		long midLimit = 250000L;
		long upperLimit = 500000L;

		CallablePrimeGenerator gen1 = new CallablePrimeGenerator(lowerLimit, midLimit);
		CallablePrimeGenerator gen2 = new CallablePrimeGenerator(midLimit, upperLimit);
		completionService.submit(gen1);
		completionService.submit(gen2);
		
        for(int completed=0; completed<2; completed++) {
        	try {
				Future<LinkedList<Long>> future = completionService.take();
				allPrimes.addAll(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
        }
		
		System.out.println("A total of " + allPrimes.size() + " primes found between " + lowerLimit + " and " + upperLimit);

		long stop_Time = System.currentTimeMillis();
		
		double duration = (stop_Time - start_Time)/1000.0;
		System.out.println("Time taken to run is " + duration + " seconds.");
		executor.shutdown();
	}


	public LinkedList<Long> call() throws Exception {
		generatePrimes();
		return getPrimes();
	}

}
