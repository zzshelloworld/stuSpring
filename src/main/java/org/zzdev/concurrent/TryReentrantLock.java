package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryReentrantLock {
    Lock lock = new ReentrantLock();

    void m() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void n() {
        try {
            lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 没有获取锁就解锁会报异常
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TryReentrantLock tryReentrantLock = new TryReentrantLock();
        new Thread(tryReentrantLock::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(tryReentrantLock::n, "t2").start();

    }
}
