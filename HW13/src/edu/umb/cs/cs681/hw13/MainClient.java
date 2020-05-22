package edu.umb.cs.cs681.hw13;

public class MainClient {
	public static void main(String[] args) {
		ThreadSafeBankAccount bankAccount = new ThreadSafeBankAccount();
		DepositRunnable depositRunnable= new DepositRunnable(bankAccount);
		WithdrawRunnable withdrawRunnable = new WithdrawRunnable(bankAccount);
		Thread[] threads = new Thread[15];
		Thread[] withdrawThreads = new Thread[15];
		for (int i = 0; i < 15; i++) {
			Thread depositThread = new Thread(depositRunnable);
			depositThread.start();
			threads[i] = depositThread;
			Thread withdrawThread = new Thread(withdrawRunnable);
			withdrawThread.start();
			withdrawThreads[i] = withdrawThread;
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		depositRunnable.setDone();
		withdrawRunnable.setDone();
		for (int i = 0; i < 15; i++) {
			threads[i].interrupt();
			withdrawThreads[i].interrupt();
			try {
				threads[i].join();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
