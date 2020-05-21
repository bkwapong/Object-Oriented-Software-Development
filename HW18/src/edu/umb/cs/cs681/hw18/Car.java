package edu.umb.cs.cs681.hw18;

public class Car {
	private int price, year, mileage;
	private String make, model;
	
	public Car(String make, String model, int year, int price, int mileage) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.mileage = mileage;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getPrice() {
		return price;
	}
	public int getMileage() {
		return mileage;
	}
}
