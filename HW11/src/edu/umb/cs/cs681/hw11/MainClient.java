package edu.umb.cs.cs681.hw11;

public class MainClient implements Runnable {

	private Address addr1 = new Address("XXX Street", "XXX City", "XXX State", 11110);
	private Address addr2 = new Address("YYY Street", "YYY City", "YYY State", 11111);
	private Customer customer1 = new Customer(addr1);
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MainClient());
		Thread t2 = new Thread(new MainClient());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public void run() {
		System.out.println("get customer's address:");
		customer1.getAddress();
		System.out.println("set customer's address to address 2:");
		customer1.setAddress(addr2);
		System.out.println("set customer's address back to address 1 using customer.setAddress( customer.getAddress().change( ... ) );");
		customer1.setAddress(customer1.getAddress().change("XXX Street", "XXX City", "XXX State", 11110));
	}
}
