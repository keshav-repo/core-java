package org.learning.trd;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        System.out.println("some more thing:::"+ Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
}
