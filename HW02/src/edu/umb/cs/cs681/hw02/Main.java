package edu.umb.cs.cs681.hw02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(new Car("Toyota", "Camry", 2018, 15790, 3500));
        cars.add(new Car("Toyota", "Corolla", 2019, 13730, 9200));
        cars.add(new Car("Toyota", "Prius", 2017, 11210, 29000));
        cars.add(new Car("Honda", "Accord", 2019, 17990, 5200));
        cars.add(new Car("Honda", "CR-V", 2016, 10850, 15780));
        cars.add(new Car("Honda", "Civic", 2017, 12570, 13500));
        cars.add(new Car("Hyundai", "Sonata", 2018, 16460, 33765));
        cars.add(new Car("BMW", "325i", 2015, 11180, 57770));
        cars.add(new Car("BMW", "X5", 2020, 41999, 4200));
        cars.add(new Car("Hyundai", "Elantra", 2019, 14150, 19720));

        System.out.println();
        System.out.println("*************");
        System.out.println("Car details:");
        System.out.println("*************");
        System.out.println();
        for(Car car: cars){
            System.out.println(car.getMake() + " " + car.getModel() + "\nYear: " + car.getYear() + 
            		"\nMileage:" + car.getMileage()+ "\nPrice: " + car.getPrice());
            System.out.println("---------------");
        }

  
        System.out.println();
        Integer minimumPrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0 , (result, carPrice) -> {
           if (result == 0) {
               return carPrice;
           }
           else if (carPrice < result) {
               return carPrice;
           }
           else {
               return result;
           }
        });
        
        
        Integer maximumPrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
            if (result == 0)
                return carPrice;
            else if (carPrice > result)
                return carPrice;
            else
                return result;
        });

        
        Integer count = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
        	if(carPrice < 15000) ++result; return result;});
        
        Integer totalCount = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
        	if(carPrice > -1) ++result; return result;});
        
        
        System.out.println("=====================");
        System.out.println("Min car price: " + minimumPrice);
        System.out.println("---------------------");
        System.out.println("Max car price: " + maximumPrice);
        System.out.println("---------------------");
        System.out.println("Cars less than $15000: " + count);
        System.out.println("---------------------------");
        System.out.println("Total Count of the cars: " + totalCount);
        System.out.println("===========================");
    }
}