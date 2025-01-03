package org.learning.misc;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private double speed;

    public void start() {
        System.out.println("The vehicle starts.");
    }
    public void stop() {
        this.speed = 0;
        System.out.println("The vehicle stops. Current speed: " + speed + " km/h.");
    }
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
    }
}

class Bike extends Vehicle{

    public Bike(String make, String model, int year) {
        super(make, model, year);
    }
}