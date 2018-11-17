package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;

public class T09 {
    synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
    synchronized void e2() {
        System.out.println("e2 start");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T09Expansion e = new T09Expansion();
        e.e1();
        System.out.println("e2 end");
    }


    public static void main(String[] args) {
        T09 t = new T09();
//        new Thread(t::m1, "mm").start();
        new Thread(t::e2, "ee").start();
    }
}
