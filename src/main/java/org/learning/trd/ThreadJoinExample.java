package org.learning.trd;

public class ThreadJoinExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");

        t1.start();

        try{
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t2.start();
    }
}
