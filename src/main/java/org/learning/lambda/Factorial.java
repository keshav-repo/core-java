package org.learning.lambda;

interface NumericFunction{
    int func(int n);
}
interface SomeFunc<T>{
    T func(T t);
}
public class Factorial {
    public static void main(String[] args) {
        SomeFunc<Integer> fact = (n -> {
            int res = 1;
            for(int i=1; i<=n; i++){
                res = res*i;
            }
            return res;
        });
        System.out.println("factorial of 10 "+fact.func(3));
    }
}
