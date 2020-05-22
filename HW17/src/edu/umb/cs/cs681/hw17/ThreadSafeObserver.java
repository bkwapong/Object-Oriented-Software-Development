package edu.umb.cs.cs681.hw17;

@FunctionalInterface
public interface ThreadSafeObserver {
	public void update(ThreadSafeObservable obs, Object obj);
}
