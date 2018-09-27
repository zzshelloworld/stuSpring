package org.zzdev.concurrent;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class PutGetContainer<T> {
    // 注意使用linkedList能够保证顺序
    LinkedList<T> container = new LinkedList<>();
    final int Max = 10;
    int count = 0;

    synchronized void put(T t) {
        while (container.size() == Max) {
            // wait 基本上就和 while 一起使用
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        container.add(t);
        System.out.println(Thread.currentThread().getName() + " " + t);
        count++;
        this.notifyAll();
    }

    synchronized T get() {
        while (container.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        T t = container.removeFirst();
        System.out.println(Thread.currentThread().getName() + " " + t);
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        PutGetContainer<String> c = new PutGetContainer<>();
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
