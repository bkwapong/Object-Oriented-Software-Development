package edu.umb.cs.cs681.hw14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionControl {
	private int currentVisitors = 0;
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	private Condition sufficientCondition = lock.newCondition();
	private Condition notSufficientCondition = lock.newCondition();
	
	public void enter() {
		lock.lock();
		System.out.println("Enter Lock obtained");
		try{
			System.out.println("Thread " + Thread.currentThread().getId() + " VISITOR ENTER: current Visitors = " + 
					currentVisitors);

			while(currentVisitors >= 5){
				System.out.println("Thread " + Thread.currentThread().getId()
						+ " Too many visitors. Please wait for a while!");
				sufficientCondition.await();
			}
			currentVisitors ++;
			System.out.println("Thread " + Thread.currentThread().getId() + " VISITOR ENTER: current Visitors after latest entry = " + 
					currentVisitors);
			notSufficientCondition.signalAll();
		}
		catch (InterruptedException exception){
			// exception.printStackTrace();
			System.out.println(exception);
		}
		finally{
			lock.unlock();
			System.out.println("Enter Lock released");
		}

	}
	
	public void exit() {
		lock.lock();
		System.out.println("Exit Lock obtained");
		try{
			System.out.println("Thread " + Thread.currentThread().getId() + " VISITOR Exit: current Visitors = " + 
					currentVisitors);
			while(currentVisitors <= 0) {
				System.out.println("Thread " + Thread.currentThread().getId()
						+ " no Vistior to exit");
				notSufficientCondition.await();
			}
			
			if(!(currentVisitors <= 0)) {
				currentVisitors --;
			}
			System.out.println("Thread " + Thread.currentThread().getId() + " VISITOR Exit: current Visitors after exit = " + 
					currentVisitors);
			sufficientCondition.signalAll();
		}
		catch (InterruptedException exception){
			// exception.printStackTrace();
			System.out.println(exception);
		}
		finally{
			lock.unlock();
			System.out.println("Exit Lock released");
		}
	}
	
	public int countCurrentVisitors(){
		return currentVisitors; 
	}
}
