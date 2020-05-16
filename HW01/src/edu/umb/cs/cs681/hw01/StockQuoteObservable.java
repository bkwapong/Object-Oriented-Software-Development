package edu.umb.cs.cs681.hw01;

import java.util.HashMap;
import java.util.LinkedList;

public class StockQuoteObservable extends Observable{

	protected HashMap<String, Float> hash;

	public StockQuoteObservable() {
		observers = new LinkedList<Observer>();
		hash = new HashMap<>();
	}
	
	public void changeQuote(String t,float q) {
		this.hash.put(t,q);
		setChanged();
		System.out.println("**********************");
		System.out.println(getClass().getSimpleName());
		System.out.println("**********************");
		System.out.println(hash);
		System.out.println();
	}
	
	public HashMap<String, Float> getHash() {
		return hash;
	}
	
}