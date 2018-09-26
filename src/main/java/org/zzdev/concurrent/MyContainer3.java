package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
// 如果不要求 数据同步，只是线程间的通信
public class MyContainer3 {
    private List array = new ArrayList();

    void add(Object o) {
        array.add(o);
    }

    int size() {
        return array.size();
    }

    public static void main(String[] args) {
        MyContainer3 m = new MyContainer3();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("校验 " + m.size());
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                m.array.add(new Object());
                if (i == 5) {
                    latch.countDown();
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
    }

}
