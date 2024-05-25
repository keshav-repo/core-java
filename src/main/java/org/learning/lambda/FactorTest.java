package org.learning.lambda;

interface Factor{
    boolean test(int n, int d);
}
public class FactorTest {
    public static void main(String[] args) {
        Factor factor = (a,b)->(a%b)==0;
        System.out.println("is factor "+factor.test(10,2));
    }
}
