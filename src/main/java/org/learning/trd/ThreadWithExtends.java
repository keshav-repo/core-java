package org.learning.trd;

public class ThreadWithExtends extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("printing in run method of thread");
    }

    public static void main(String[] args) {
        ThreadWithExtends thread = new ThreadWithExtends();
        thread.start();
    }
}
