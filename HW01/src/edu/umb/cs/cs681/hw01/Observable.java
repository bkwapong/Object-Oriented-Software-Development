package edu.umb.cs.cs681.hw01;

import java.util.LinkedList;

abstract class Observable {

    protected boolean changed;
    protected LinkedList<Observer> observers;
    
    protected void addObserver(Observer o) {
    	if(!observers.contains(o)) {
    		observers.add(o);
    		}
    	changed = false;
    }

    protected void deleteObserver(Observer o) {
    	System.out.println("Deleting Observer: " + o);
    	observers.remove(o);
    }

    protected void deleteObserver() {
    	System.out.println("Deleting All Observers...");
    	observers.removeAll(observers);
    }

    protected void setChanged() {
    	changed = true;
    }

    public boolean hasChanged() {
    	return changed;
    }
    
    protected void clearChanged() {
    	changed = false;
    }
    
    public int countObservers() {
    	return observers.size();
    }

    public void notifyObservers(Object arg) {
    	// Get name of Object and print changes
    	System.out.println(getClass().getSimpleName() + " Notifying observers of changes...");
		if(hasChanged()) {
			observers.forEach((Observer observers) -> observers.update(this, arg));
			clearChanged();
		}
    }
}