package edu.umb.cs.cs681.hw01;

import java.util.LinkedList;

public class DJIAQuoteObservable extends Observable {	
	
	protected float quote;
	public DJIAQuoteObservable() {
		observers = new LinkedList<Observer>();
	}

	public float getQuote() {
		return quote;
	}
	public void changeQuote(float q) {
    	this.quote = q;
    	this.setChanged();
    	System.out.println("**********************");
    	System.out.println(getClass().getSimpleName());
    	System.out.println("**********************");
    	System.out.println(quote);
    	System.out.println();
    }
}