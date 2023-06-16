package org.learning.oop;

public class OuterClass {
    private int outerData;

    // OuterClass constructor and other methods

    public class InnerClass {
        private int innerData;
        public InnerClass(int innerData) {
            this.innerData = innerData;
        }
        public void innerMethod() {
            System.out.println("Inner method called");
            System.out.println("Inner data: " + innerData);
            System.out.println("Outer data: " + outerData);
        }
    }
    public void outerMethod() {
        InnerClass innerObject = new InnerClass(42);
        innerObject.innerMethod();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }
}
