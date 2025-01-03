package org.learning.misc;

import java.util.Deque;
import java.util.LinkedList;

class ParenthesisCheck{
    public boolean isBalanced(String expression){
        Deque<Character> stack = new LinkedList<>();

        for(char ch: expression.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else if(ch==')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String expression1 = "(1 + 2) * (3 / (4 - 5))";
        String expression2 = "(1 + 2) * (3 / (4 - 5)";

        ParenthesisCheck parenthesisCheck = new ParenthesisCheck();

        System.out.println(parenthesisCheck.isBalanced(expression1));
        System.out.println(parenthesisCheck.isBalanced(expression2));
    }
}
