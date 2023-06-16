package org.learning.oop;

public class Anonymous {
    public static void main(String[] args) {
        // Create an anonymous inner class that implements the Runnable interface
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous inner class!");
            }
        };

        // Create a thread and pass the anonymous inner class as the target
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
