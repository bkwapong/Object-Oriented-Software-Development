package edu.umb.cs.cs681.hw15;

@FunctionalInterface
public interface ThreadSafeObserver {
    void update(ThreadSafeObservable o, Object obj);
}
