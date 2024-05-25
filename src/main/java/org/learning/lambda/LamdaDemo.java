package org.learning.lambda;

interface MyNumber{
    double getValue();
}
public class LamdaDemo {
    public static void main(String[] args) {
        MyNumber myNumber;

        myNumber = ()-> 123.45;
        System.out.println(myNumber.getValue());

        myNumber = ()-> Math.random()*100;
        System.out.println(myNumber.getValue());
    }
}
