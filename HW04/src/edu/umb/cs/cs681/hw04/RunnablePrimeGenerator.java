package edu.umb.cs.cs681.hw04;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {
	
	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		
		System.out.println("----------Using 1 Thread----------");
		RunnablePrimeGenerator gen = new RunnablePrimeGenerator(1, 2000000);
		Thread t = new Thread(gen);
		
		long start_time_1t = System.currentTimeMillis();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {}
		
		long stop_time_1t = System.currentTimeMillis();
		double elapsed_time_1t = stop_time_1t - start_time_1t;

		gen.getPrimes();//.forEach((Long prime)->System.out.println(prime + ", "));
		
		long primeNum = gen.getPrimes().size();
		System.out.println("\n" + primeNum + " prime numbers are found in total.");
		
		System.out.println();
		System.out.println("Elapsed Time = " + elapsed_time_1t/1000 + " seconds");
		System.out.println();
		
		System.out.println("----------Using 2 Threads----------");
		RunnablePrimeGenerator gen1_2t = new RunnablePrimeGenerator(1, 1000000);
		RunnablePrimeGenerator gen2_2t = new RunnablePrimeGenerator(1000001, 2000000);
		Thread t1 = new Thread(gen1_2t);
		Thread t2 = new Thread(gen2_2t);
		
		long start_time_2t = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		
		long stop_time_2t = System.currentTimeMillis();
		double elapsed_time_2t = stop_time_2t - start_time_2t;

		gen1_2t.getPrimes();//.forEach((Long prime)->System.out.print(prime + ", "));
		gen2_2t.getPrimes();//.forEach((Long prime)->System.out.print(prime + ", "));
		
		long primeNum_2t = gen1_2t.getPrimes().size() + gen2_2t.getPrimes().size();
		System.out.println("\n" + primeNum_2t + " prime numbers are found in total.");
		
		System.out.println();
		System.out.println("Elapsed Time = " + elapsed_time_2t/1000 + " seconds");
		System.out.println();
		
		System.out.println("----------Using 4 Threads----------");
		RunnablePrimeGenerator gen1_4t = new RunnablePrimeGenerator(1, 500000);
		RunnablePrimeGenerator gen2_4t = new RunnablePrimeGenerator(500001, 1000000);
		RunnablePrimeGenerator gen3_4t = new RunnablePrimeGenerator(1000001, 1500000);
		RunnablePrimeGenerator gen4_4t = new RunnablePrimeGenerator(1500001, 2000000);
		Thread t1_4t = new Thread(gen1_4t);
		Thread t2_4t = new Thread(gen2_4t);
		Thread t3_4t = new Thread(gen3_4t);
		Thread t4_4t = new Thread(gen4_4t);
		
		long start_time_4t = System.currentTimeMillis();
		t1_4t.start();
		t2_4t.start();
		t3_4t.start();
		t4_4t.start();
		try {
			t1_4t.join();
			t2_4t.join();
			t3_4t.join();
			t4_4t.join();
		} catch (InterruptedException e) {}
		
		long stop_time_4t = System.currentTimeMillis();
		double elapsed_time_4t = stop_time_4t - start_time_4t;

		gen1_4t.getPrimes();
		gen2_4t.getPrimes();
		gen3_4t.getPrimes();
		gen4_4t.getPrimes();
		
		long primeNum_4t = gen1_4t.getPrimes().size() + gen2_4t.getPrimes().size() + gen3_4t.getPrimes().size()
				+ gen4_4t.getPrimes().size();
		System.out.println("\n" + primeNum_4t + " prime numbers are found in total.");
		
		System.out.println();
		System.out.println("Elapsed Time = " + elapsed_time_4t/1000 + " seconds");
		System.out.println();
		
		System.out.println("----------Using 8 Threads----------");
		RunnablePrimeGenerator gen1_8t = new RunnablePrimeGenerator(1, 250000);
		RunnablePrimeGenerator gen2_8t = new RunnablePrimeGenerator(250001, 500000);
		RunnablePrimeGenerator gen3_8t = new RunnablePrimeGenerator(500001, 750000);
		RunnablePrimeGenerator gen4_8t = new RunnablePrimeGenerator(750001, 1000000);
		RunnablePrimeGenerator gen5_8t = new RunnablePrimeGenerator(1000001, 1250000);
		RunnablePrimeGenerator gen6_8t = new RunnablePrimeGenerator(1250001, 1500000);
		RunnablePrimeGenerator gen7_8t = new RunnablePrimeGenerator(1500001, 1750000);
		RunnablePrimeGenerator gen8_8t = new RunnablePrimeGenerator(1750001, 2000000);
		Thread t1_8t = new Thread(gen1_8t);
		Thread t2_8t = new Thread(gen2_8t);
		Thread t3_8t = new Thread(gen3_8t);
		Thread t4_8t = new Thread(gen4_8t);
		Thread t5_8t = new Thread(gen5_8t);
		Thread t6_8t = new Thread(gen6_8t);
		Thread t7_8t = new Thread(gen7_8t);
		Thread t8_8t = new Thread(gen8_8t);
		
		long start_time_8t = System.currentTimeMillis();
		t1_8t.start();
		t2_8t.start();
		t3_8t.start();
		t4_8t.start();
		t5_8t.start();
		t6_8t.start();
		t7_8t.start();
		t8_8t.start();
		try {
			t1_8t.join();
			t2_8t.join();
			t3_8t.join();
			t4_8t.join();
			t5_8t.join();
			t6_8t.join();
			t7_8t.join();
			t8_8t.join();
		} catch (InterruptedException e) {}
		
		long stop_time_8t = System.currentTimeMillis();
		double elapsed_time_8t = stop_time_8t - start_time_8t;

		gen1_8t.getPrimes();
		gen2_8t.getPrimes();
		gen3_8t.getPrimes();
		gen4_8t.getPrimes();
		gen5_8t.getPrimes();
		gen6_8t.getPrimes();
		gen7_8t.getPrimes();
		gen8_8t.getPrimes();
		
		long primeNum_8t = gen1_8t.getPrimes().size() + gen2_8t.getPrimes().size() + gen3_8t.getPrimes().size()
				+ gen4_8t.getPrimes().size() + gen5_8t.getPrimes().size() + gen6_8t.getPrimes().size()
				+ gen7_8t.getPrimes().size() + gen8_8t.getPrimes().size();
		System.out.println("\n" + primeNum_8t + " prime numbers are found in total.");
		
		System.out.println();
		System.out.println("Elapsed Time = " + elapsed_time_8t/1000 + " seconds");
		System.out.println();
        
		System.out.println("----------Using 16 Threads----------");
		RunnablePrimeGenerator gen1_16t = new RunnablePrimeGenerator(1, 125000);
		RunnablePrimeGenerator gen2_16t = new RunnablePrimeGenerator(125001, 250000);
		RunnablePrimeGenerator gen3_16t = new RunnablePrimeGenerator(250001, 375000);
		RunnablePrimeGenerator gen4_16t = new RunnablePrimeGenerator(375001, 500000);
		RunnablePrimeGenerator gen5_16t = new RunnablePrimeGenerator(500001, 625000);
		RunnablePrimeGenerator gen6_16t = new RunnablePrimeGenerator(625001, 750000);
		RunnablePrimeGenerator gen7_16t = new RunnablePrimeGenerator(750001, 875000);
		RunnablePrimeGenerator gen8_16t = new RunnablePrimeGenerator(875001, 1000000);
		RunnablePrimeGenerator gen9_16t = new RunnablePrimeGenerator(1000001, 1125000);
		RunnablePrimeGenerator gen10_16t = new RunnablePrimeGenerator(1125001, 1250000);
		RunnablePrimeGenerator gen11_16t = new RunnablePrimeGenerator(1250001, 1375000);
		RunnablePrimeGenerator gen12_16t = new RunnablePrimeGenerator(1375001, 1500000);
		RunnablePrimeGenerator gen13_16t = new RunnablePrimeGenerator(1500001, 1625000);
		RunnablePrimeGenerator gen14_16t = new RunnablePrimeGenerator(1625001, 1750000);
		RunnablePrimeGenerator gen15_16t = new RunnablePrimeGenerator(1750001, 1875000);
		RunnablePrimeGenerator gen16_16t = new RunnablePrimeGenerator(1875001, 2000000);
		Thread t1_16t = new Thread(gen1_16t);
		Thread t2_16t = new Thread(gen2_16t);
		Thread t3_16t = new Thread(gen3_16t);
		Thread t4_16t = new Thread(gen4_16t);
		Thread t5_16t = new Thread(gen5_16t);
		Thread t6_16t = new Thread(gen6_16t);
		Thread t7_16t = new Thread(gen7_16t);
		Thread t8_16t = new Thread(gen8_16t);
		Thread t9_16t = new Thread(gen9_16t);
		Thread t10_16t = new Thread(gen10_16t);
		Thread t11_16t = new Thread(gen11_16t);
		Thread t12_16t = new Thread(gen12_16t);
		Thread t13_16t = new Thread(gen13_16t);
		Thread t14_16t = new Thread(gen14_16t);
		Thread t15_16t = new Thread(gen15_16t);
		Thread t16_16t = new Thread(gen16_16t);
		
		long start_time_16t = System.currentTimeMillis();
		t1_16t.start();
		t2_16t.start();
		t3_16t.start();
		t4_16t.start();
		t5_16t.start();
		t6_16t.start();
		t7_16t.start();
		t8_16t.start();
		t9_16t.start();
		t10_16t.start();
		t11_16t.start();
		t12_16t.start();
		t13_16t.start();
		t14_16t.start();
		t15_16t.start();
		t16_16t.start();
		try {
			t1_16t.join();
			t2_16t.join();
			t3_16t.join();
			t4_16t.join();
			t5_16t.join();
			t6_16t.join();
			t7_16t.join();
			t8_16t.join();
			t9_16t.join();
			t10_16t.join();
			t11_16t.join();
			t12_16t.join();
			t13_16t.join();
			t14_16t.join();
			t15_16t.join();
			t16_16t.join();
		} catch (InterruptedException e) {}
		
		long stop_time_16t = System.currentTimeMillis();
		double elapsed_time_16t = stop_time_16t - start_time_16t;

		gen1_16t.getPrimes();
		gen2_16t.getPrimes();
		gen3_16t.getPrimes();
		gen4_16t.getPrimes();
		gen5_16t.getPrimes();
		gen6_16t.getPrimes();
		gen7_16t.getPrimes();
		gen8_16t.getPrimes();
		gen9_16t.getPrimes();
		gen10_16t.getPrimes();
		gen11_16t.getPrimes();
		gen12_16t.getPrimes();
		gen13_16t.getPrimes();
		gen14_16t.getPrimes();
		gen15_16t.getPrimes();
		gen16_16t.getPrimes();
		
		long primeNum_16t = gen1_16t.getPrimes().size() + gen2_16t.getPrimes().size() + gen3_16t.getPrimes().size()
				+ gen4_16t.getPrimes().size() + gen5_16t.getPrimes().size() + gen6_16t.getPrimes().size()
				+ gen7_16t.getPrimes().size() + gen8_16t.getPrimes().size() + gen9_16t.getPrimes().size()
				+ gen10_16t.getPrimes().size() + gen11_16t.getPrimes().size() + gen12_16t.getPrimes().size() 
				+ gen13_16t.getPrimes().size() + gen14_16t.getPrimes().size() + gen15_16t.getPrimes().size() 
				+ gen16_16t.getPrimes().size();
		System.out.println("\n" + primeNum_16t + " prime numbers are found in total.");
		
		System.out.println();
		System.out.println("Elapsed Time = " + elapsed_time_16t/1000 + " seconds");
		System.out.println();
        
	}

}
