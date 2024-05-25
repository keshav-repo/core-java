package org.learning.trd;

import java.util.concurrent.*;

public class ScheduledPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService poolObject = Executors.newScheduledThreadPool(5);

//        Future<?> future = poolObject.schedule(()->{
//            System.out.println("Thread picked the task");
//            try{
//                Thread.sleep(6000);
//            }catch (Exception e){
//
//            }
//            System.out.println("Thread completed the task");
//        }, 1, TimeUnit.SECONDS);

        Future<?> future = poolObject.scheduleWithFixedDelay(()->{
            System.out.println("Thread picked the task");
            try{
                Thread.sleep(6000);
            }catch (Exception e){

            }
            System.out.println("Thread completed the task");
        }, 1, 3, TimeUnit.SECONDS);


        try{
            Thread.sleep(7000);
        }catch (Exception e){
        }
        future.cancel(true);

    }
}
