package org.zzdev.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {
    Lock lock = new ReentrantLock(true);
    // 加true 为什么是交替出现
    void m() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock::m, "t1");
        Thread t2 = new Thread(fairLock::m, "t2");
        t1.start();
        t2.start();
    }
}
