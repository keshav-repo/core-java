package org.learning.trd;

public class CreateDeamonThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("printing inside the deamon thread");
        Thread daemon = Thread.currentThread();
        System.out.println("Thread Name: "+ daemon.getName());
    }

    public static void main(String[] args) {
        CreateDeamonThread createDeamonThread = new CreateDeamonThread();
        createDeamonThread.setDaemon(true);
        createDeamonThread.setName("deamon-thread");
        createDeamonThread.setPriority(Thread.MIN_PRIORITY);
        createDeamonThread.start();
    }
}
