package org.learning.lambda;


interface StringFun {
    String func(String n);
}

public class LambdaAsArgument {
    static String stringOp(StringFun sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda add power to java";
        String outStr;

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("upper case string " + outStr);

        // code to remove white spaces
        outStr = stringOp((str) -> {
            String res = "";
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)!=' '){
                    res += str.charAt(i);
                }
            }
            return res;
        }, inStr);
        System.out.println(outStr);

        // function to reverse function
        StringFun reverse = (str)->{
            char[] rev = new char[str.length()];
            int start = 0;
            for(int i=str.length()-1; i>=0; i--){
                rev[start++] = str.charAt(i);
            }
            return String.valueOf(rev);
        };
        System.out.println(stringOp(reverse, inStr));
    }
}
