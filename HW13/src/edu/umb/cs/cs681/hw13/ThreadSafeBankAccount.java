package edu.umb.cs.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount {
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();

	public ThreadSafeBankAccount() {
	}
	
	public void deposit(double amount) {
		lock.lock();
		try {
			System.out.println("Deposit Locked obtained");
			System.out.println("Thread " + Thread.currentThread().getId() + " current balance: " + balance);
			while (balance >= 300) {

				System.out.println("Thread " + Thread.currentThread().getId() + 
						" (d): await(): Balance exceeds the upper limit.");
				belowUpperLimitFundsCondition.await();

			}
			balance += amount;
			System.out.println("Thread " + Thread.currentThread().getId() + 
					" (d): new balance: " + balance);
			sufficientFundsCondition.signalAll();
		} catch (InterruptedException exception) {
			System.out.println(exception);
		} finally {
			lock.unlock();
			System.out.println("Deposit Lock released");
		}
	}
	
	public void withdraw(double amount) {
		lock.lock();
		try {
			System.out.println("Withdraw Locked obtained");
			System.out.println("Thread " + Thread.currentThread().getId() + " current balance: " + balance);

			while (balance <= 0) {
				System.out.println("Thread " + Thread.currentThread().getId() + 
						" (w): await(): Insufficient funds");
				sufficientFundsCondition.await();
			}
			balance -= amount;
			System.out.println("Thread " + Thread.currentThread().getId() + 
					" (w): new balance: " + balance);
			belowUpperLimitFundsCondition.signalAll();
		} catch (InterruptedException exception) {
			System.out.println(exception);
		} finally {
			lock.unlock();
			System.out.println("Withdraw Lock released");
		}
	}
}
