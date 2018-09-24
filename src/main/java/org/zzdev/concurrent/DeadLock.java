package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    Object a = new Object();
    Object b = new Object();
    void aVoid(){
        synchronized (a){
            System.out.println(Thread.currentThread().getName()+" a");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+" b");
            }
        }

    }

    void bVoid(){
        synchronized (b){
            System.out.println(Thread.currentThread().getName()+" b");
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+" a");
            }
        }

    }

    public static void main(String[] args){
        DeadLock d = new DeadLock();
        new Thread(d::aVoid, "线程1").start();
        new Thread(d::bVoid, "线程2").start();

    }

}
