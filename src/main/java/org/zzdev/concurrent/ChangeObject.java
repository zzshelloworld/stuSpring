package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;

public class ChangeObject {
//    Object t;

    private synchronized void m() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ChangeObject t = new ChangeObject();
        new Thread(t::m, "one").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t = new ChangeObject();
        new Thread(t::m, "two").start();
    }
}
