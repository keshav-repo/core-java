package org.learning.misc;

import java.util.Deque;
import java.util.LinkedList;

public class BrowserHistory {
    private Deque<String> deque;

    public BrowserHistory() {
        deque = new LinkedList<>();
    }

    public void visitWebsite(String url){
        deque.addFirst(url);
    }

    public String goBack(){
        return deque.pollLast();
    }

}
