package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadError {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "thread begin");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;
            }
        }
    }

    public static void main(String[] args) {
        ThreadError t = new ThreadError();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m, "t2").start();
    }
}
