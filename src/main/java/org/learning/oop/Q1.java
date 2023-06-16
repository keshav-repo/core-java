package org.learning.oop;

class A {
    public void methodOne() {
        System.out.println("A");
    }

    public void methodTwo() {
        System.out.println("A");
    }
}

class B extends A {
    public void methodOne() {
        System.out.println("B");
    }

    public void methodTwo(int num) {
        System.out.println("B: " + num);
    }
}
public class Q1 {
    public static void main(String[] args) {
        A obj = new B();
        obj.methodOne();
       // obj.methodTwo(10); // compilation error
    }
}
