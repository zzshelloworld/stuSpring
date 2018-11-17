package org.zzdev.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SychronizedThis {
    private int count = 10;

    private void m() {
        System.out.println("这个是mm");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " " + count);
//            try {
//                TimeUnit.SECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private void n() {
        System.out.println("这个是nn");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " " + count);
//            try {
//                TimeUnit.SECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    // junit不支持多线程
    @Test
    public void mn() {
        SychronizedThis st = new SychronizedThis();
        new Thread(st::m, "mm").start();
        new Thread(st::n, "nan").start();


    }
}
