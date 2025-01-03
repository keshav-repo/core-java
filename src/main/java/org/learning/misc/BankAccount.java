package org.learning.misc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private double balance;
    private final ReadWriteLock lock =  new ReentrantReadWriteLock();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        lock.writeLock().lock();
        try{
            balance += amount;
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(double amount){
        lock.writeLock().lock();
        try{
            if(balance>=amount){
                balance -= amount;
            }
            else{
                System.out.println("insufficient balance");
            }
        }finally {
            lock.writeLock().unlock();
        }
    }

    public double getBalance(){
        lock.readLock().lock();
        try{
            return this.balance;
        }finally {
            lock.readLock().unlock();
        }
    }
}