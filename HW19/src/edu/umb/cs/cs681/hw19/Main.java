package edu.umb.cs.cs681.hw19;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<Car>();
		
		cars.add(new Car("Toyota", "Camry", 2018, 15790, 3500));
        cars.add(new Car("Toyota", "Corolla", 2019, 13730, 9200));
		cars.add(new Car("Toyota", "Corolla", 2017, 11250, 29200));
		cars.add(new Car("Toyota", "Corolla", 2015, 9970, 59680));
        cars.add(new Car("Toyota", "Prius", 2017, 11210, 29000));
        cars.add(new Car("Honda", "Accord", 2019, 17990, 5200));
		cars.add(new Car("Honda", "Accord", 2020, 21390, 2100));
		cars.add(new Car("Honda", "Accord", 2016, 13180, 19230));
		cars.add(new Car("Honda", "Accord", 2018, 16850, 8900));
        cars.add(new Car("Honda", "CR-V", 2016, 10850, 15780));
        cars.add(new Car("Honda", "Civic", 2017, 12570, 13500));
        cars.add(new Car("Hyundai", "Sonata", 2018, 16460, 33765));
        cars.add(new Car("BMW", "325i", 2015, 11180, 57770));
        cars.add(new Car("BMW", "X5", 2020, 41999, 4200));
        cars.add(new Car("Hyundai", "Elantra", 2019, 14150, 19720));
  
        System.out.println();
        Integer minimumPrice = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(0 , (result, carPrice) -> {
           if (result == 0) {
               return carPrice;
           }
           else if (carPrice < result) {
               return carPrice;
           }
           else {
               return result;
           }
        },
		(finalResult, intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " ->\t FinalResult: " + finalResult + "\tIntermediateResult: " + intermediateResult);
					if (finalResult < intermediateResult) {
						return finalResult;
					}
					else {
						return intermediateResult;
					}
					});
        
        
        Integer maximumPrice = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
            if (result == 0)
                return carPrice;
            else if (carPrice > result)
                return carPrice;
            else
                return result;
        },
		(finalResult,intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " ->\t FinalResult: " + finalResult + "\tIntermediateResult: " + intermediateResult);
					if (finalResult > intermediateResult) {
						return finalResult;
					}
					else {
						return intermediateResult;
					}
					});
        
        Integer count = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
        	if(carPrice < 15000) ++result; return result;}, (finalResult,intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " ->\t FinalResult: " + finalResult + "\tInterMediateResult: " + intermediateResult);
			return finalResult + intermediateResult;});
        
        Integer totalCount = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
        	if(carPrice > -1) ++result; return result;}, 
			(finalResult,intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " ->\t FinalResult: " + finalResult + "\tInterMediateResult: " + intermediateResult);
			return finalResult + intermediateResult;});
			
		Integer numModels = cars.stream().parallel().map((Car car) -> car.getModel()).distinct().reduce(0, (result, carModel) -> {
					return ++result;}, 
					(finalResult,intermediateResult) -> {
					System.out.println(Thread.currentThread().getName() + " - finalResult = " + finalResult + "; interMediateResult = " + intermediateResult);
					return finalResult+intermediateResult;
				});
				
		System.out.println();
        System.out.println("**********************************************");
        System.out.println("  \t  \t  Car Listing:");
        System.out.println("**********************************************");
        System.out.println();
		System.out.format("%-10s%-10s%-10s%-10s%-10s", "Make", "Model", "Year", "Mileage", "Price");
		System.out.println();
		System.out.println("----------------------------------------------");
        for(Car car: cars){
			System.out.format("%-10s%-10s%-10d%-10d%-10d", car.getMake(), car.getModel(), car.getYear(), car.getMileage(), car.getPrice());
            System.out.println();
        }


        System.out.println("\n\n=========================================");
        System.out.println("Min car price: \t\t\t" + minimumPrice);
        System.out.println("-----------------------------------------");
        System.out.println("Max car price: \t\t\t" + maximumPrice);
        System.out.println("-----------------------------------------");
        System.out.println("Cars less than $15000: \t\t" + count);
        System.out.println("-----------------------------------------");
        System.out.println("Total number of cars available: \t" + totalCount);
		System.out.println("-----------------------------------------");
		System.out.println("Number of different Car Models: \t" + numModels);
        System.out.println("=========================================");
    }
}