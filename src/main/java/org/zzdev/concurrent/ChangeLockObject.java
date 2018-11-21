package org.zzdev.concurrent;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ChangeLockObject {
    Object o = new Object();
    void m() {
        synchronized (o) {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        ChangeLockObject changeLockObject = new ChangeLockObject();

        new Thread(changeLockObject :: m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(changeLockObject::m, "t2");
        // 这个o就是这个新的对象的。
        changeLockObject.o = new Object();
        t2.start();
    }
}
