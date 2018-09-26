package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer2 {
    // 加锁了，不加volatile 也行（待验证）
    List array = new ArrayList();

    void add(Object o) {
        array.add(o);
    }

    int size() {
        return array.size();
    }

    public static void main(String[] args) {
        MyContainer2 m = new MyContainer2();
        final Object lock = new Object();
        // 因为加锁，所以要先启动 t2
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动");
                if (m.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2监视结束");
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    m.add(new Object());
                    if (i == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        }, "t1").start();


    }
}
