package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;

public class PutGetContainer<T> {
    List<T> container = new ArrayList<>();
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
        T t = container.remove(count);
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {

    }
}
