package edu.umb.cs.cs681.hw15;

public class MainClient {

	public static void main(String[] args) {
		
		StockQuoteObservable stockquote = new StockQuoteObservable();
		
		stockquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("User1 : " + obj);} );
		stockquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("User2 : " + obj);} );
		stockquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("User3 : " + obj);} );
		System.out.println("\nNumber of Observers/Subscriptions: " + stockquote.countObservers() + "\n");
		
		stockquote.changeQuote("AMZN", 2397);
		stockquote.notifyObservers(stockquote.getHash());
		System.out.println();
		stockquote.changeQuote("FB", 190);
		stockquote.notifyObservers(stockquote.getHash());
		System.out.println();
		stockquote.changeQuote("TSLA", 725);
		stockquote.notifyObservers(stockquote.getHash());
		System.out.println();
		stockquote.changeQuote("AMZN", 2402);
		stockquote.notifyObservers(stockquote.getHash());
		
		System.out.println();
		stockquote.deleteObservers();
		System.out.println("Number of Subscribers remaining: " + stockquote.countObservers() + "\n");
		
		System.out.println();
		DJIAQuoteObservable djiaquote = new DJIAQuoteObservable();
		
		djiaquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("observerA : " + obj);} );
		djiaquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("observerB : " + obj);} );
		djiaquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("observerC : " + obj);} );
		djiaquote.addObserver( (ThreadSafeObservable o, Object obj)->{System.out.println("observerD : " + obj);} );
		System.out.println("\nNumber of Observers/Subscriptions: " + djiaquote.countObservers() + "\n");
		
		djiaquote.changeQuote(4890);
		djiaquote.notifyObservers(djiaquote.getQuote());
		System.out.println();
		djiaquote.changeQuote(5168);
		djiaquote.notifyObservers(djiaquote.getQuote());
		System.out.println();

	}
}
