package org.learning.lambda;

interface StringFuns{
    String func(String n);
}
class StringUt{
    static String revString(String str){
        char[] rev = new char[str.length()];
        int start = 0;
        for(int i=str.length()-1; i>=0; i--){
            rev[start++] = str.charAt(i);
        }
        return String.valueOf(rev);
    }
}
public class StaticMethodRef {
    static String stringOp(StringFun sf, String s){
        return sf.func(s);
    }
    public static void main(String[] args) {
        String inStr = "Lambda add power to java";
        String outStr = stringOp(StringUt::revString, inStr);
        System.out.println(outStr);
    }
}
