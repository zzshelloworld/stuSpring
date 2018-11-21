package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;

public class StringLock {
    String a = "hello";
    String b = "hello";

    void m() {
        synchronized (a) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    void n() {
        synchronized (b) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    // 因为常量池的原因锁定的是同一个对象。
    public static void main(String[] args) {
        StringLock stringLock = new StringLock();
        new Thread(stringLock::m, "t1").start();
        new Thread(stringLock::n, "t2").start();
    }

}
