package org.learning.oop;


public class LocaLInner {
    private int outerField = 10;

    public void outerMethod() {
        // Local inner class
        class LocalInnerClass {
            public void innerMethod() {
                System.out.println("Accessing outerField from innerMethod: " + outerField);
            }
        }

        // Creating an instance of the local inner class
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.innerMethod();
    }

    public static void main(String[] args) {
        LocaLInner outer = new LocaLInner();
        outer.outerMethod();
    }
}

