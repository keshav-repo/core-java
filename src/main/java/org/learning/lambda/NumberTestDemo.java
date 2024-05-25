package org.learning.lambda;

interface NumberTest{
    boolean test(int n);
}

public class NumberTestDemo {
    public static void main(String[] args) {
        NumberTest isEven = (n)-> n%2==0;

        System.out.println("isEven "+isEven.test(10));
    }
}
