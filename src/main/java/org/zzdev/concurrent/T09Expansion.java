package org.zzdev.concurrent;

public class T09Expansion {
    void e1() {
        synchronized (this) {
            System.out.println(this.getClass() + " " + Thread.currentThread().getName());
            System.out.println("e1");
        }
    }
}
