package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer1 {
    private volatile List array = new ArrayList();

    void add(Object o) {
        array.add(o);
    }

    int size() {
        return array.size();
    }

    public static void main(String[] args) {
        MyContainer1 m = new MyContainer1();
        new Thread(()-> {
            for (int i = 0; i<10; i++) {
                m.add(new Object());
                System.out.println(Thread.currentThread().getName()+ " " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(()->{
           while (true) {
               if (m.size() ==5) {
                   break;
               }
           }
           System.out.println("t2结束");
        }, "t2").start();
    }
}
