package org.zzdev.concurrent;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PutGetContainer1<T> {
    // 注意使用linkedList能够保证顺序
    LinkedList<T> container = new LinkedList<>();
    final int Max = 10;
    int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition put = lock.newCondition();
    private Condition get = lock.newCondition();

    void put(T t) {
        try {
            lock.lock();
            while (container.size() == Max) {
                // wait 基本上就和 while 一起使用
                put.await();
            }
            container.add(t);
            System.out.println(Thread.currentThread().getName() + " " + t);
            count++;
            get.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    T get() {
        // 注意T 的处理方式
        T t = null;
        try {
            lock.lock();
            while (container.size() == 0) {
                get.await();
            }
            count--;
            t = container.removeFirst();
            System.out.println(Thread.currentThread().getName() + " " + t);
            put.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        PutGetContainer1<String> c = new PutGetContainer1<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    c.get();
                }
            }, "消费者 " + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(String.valueOf(j));
                }
            }, "生产者 " + i).start();
        }
    }
}
