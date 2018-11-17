package org.zzdev.concurrent;

public class T04 {
    public static void main(String[] args) {
        System.out.println(T04.class);
        T04 t = new T04();
        Thread thread = new Thread(t::m);
    }

    public synchronized void m() {
        System.out.println("aa");
    }
}
