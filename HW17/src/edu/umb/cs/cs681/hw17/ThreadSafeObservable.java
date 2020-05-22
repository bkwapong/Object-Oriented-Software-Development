package edu.umb.cs.cs681.hw17;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadSafeObservable {
	
	private ConcurrentLinkedQueue<ThreadSafeObserver> observers;
	
	private AtomicBoolean changed;

	public ThreadSafeObservable() {
		observers = new ConcurrentLinkedQueue<ThreadSafeObserver>();
		changed = new AtomicBoolean();
	}
	
	public void addObserver(ThreadSafeObserver o) {
		if(o == null) throw new NullPointerException();

		observers.add(o);
	}
	
	public void deleteObserver(ThreadSafeObserver o) {

		if(observers.remove(o)) {
				System.out.println("Observer removed");
		}else {
			System.out.println("This observer does not exist");
		}
		
	}
	
	public void deleteObservers() {
		observers.clear();
	}
	
	public int countObservers() {
		return observers.size();
	}
	
	protected void setChanged() {
		changed.set(true);
	}
	
	protected void clearChanged() {
		changed.set(false);
	}
	
	public boolean hasChanged() {
		return changed.get();
	}
	
	public void notifyObservers() {
		notifyObservers(null);
	}
	
	public void notifyObservers(Object obj) {
		if(!changed.get()) {
			return;
		}

		observers.forEach(n -> n.update(this, obj));

		clearChanged();
	}
}
