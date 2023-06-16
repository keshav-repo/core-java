package org.learning.oop;

public class StaticNestedClass {
    // Outer class members and methods
    public static class NestedClass {
        // Nested class members and methods
        public void display() {
            System.out.println("Inside the static nested class");
        }
    }
    // Outer class members and methods
    public static void main(String[] args) {
        StaticNestedClass.NestedClass nestedObject = new StaticNestedClass.NestedClass();
        nestedObject.display();
    }
}
