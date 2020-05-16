package edu.umb.cs.cs681.hw01;

public class Main {

	public static void main(String[] args) {
		
		StockQuoteObservable stockquote = new StockQuoteObservable();
		
		//stockquote.changeQuote("AAPL", 195);
		stockquote.addObserver( (Observable o, Object obj)->{System.out.println("User1 : " + obj);} );
		stockquote.addObserver( (Observable o, Object obj)->{System.out.println("User2 : " + obj);} );
		stockquote.addObserver( (Observable o, Object obj)->{System.out.println("User3 : " + obj);} );
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
		stockquote.deleteObserver();
		System.out.println("Number of Subscribers remaining: " + stockquote.countObservers() + "\n");
		
		System.out.println();
		DJIAQuoteObservable djiaquote = new DJIAQuoteObservable();
		
		//djiaquote.changeQuote(3672);
		djiaquote.addObserver( (Observable o, Object obj)->{System.out.println("observerA : " + obj);} );
		djiaquote.addObserver( (Observable o, Object obj)->{System.out.println("observerB : " + obj);} );
		djiaquote.addObserver( (Observable o, Object obj)->{System.out.println("observerC : " + obj);} );
		djiaquote.addObserver( (Observable o, Object obj)->{System.out.println("observerD : " + obj);} );
		System.out.println("\nNumber of Observers/Subscriptions: " + djiaquote.countObservers() + "\n");
		
		djiaquote.changeQuote(4890);
		djiaquote.notifyObservers(djiaquote.getQuote());
		System.out.println();
		djiaquote.changeQuote(5168);
		djiaquote.notifyObservers(djiaquote.getQuote());
		System.out.println();

	}
}
