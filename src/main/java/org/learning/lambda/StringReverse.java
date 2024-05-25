package org.learning.lambda;

interface StringFunc{
    String func(String s);
}
public class StringReverse {
    public static void main(String[] args) {
        SomeFunc<String> reverse = (str)->{
            char[] rev = new char[str.length()];
            int start = 0;
            for(int i=str.length()-1; i>=0; i--){
                rev[start++] = str.charAt(i);
            }
            return String.valueOf(rev);
        };
        System.out.println("reverse of world "+ reverse.func("World"));
    }
}
