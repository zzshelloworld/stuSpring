package org.zzdev.concurrent;

public class Synchronized2 implements Runnable {

    private int count = 100;

    @Override
    public synchronized void run() {
        //测试结果和预想不一致
        count--;
        System.out.println(Thread.currentThread().getName() + " count:" + count);
    }

    public static void main(String[] args) {
        Synchronized2 t = new Synchronized2();
        for (int i = 50; i>=0; i--) {
            new Thread(t, "Thread" + i).start();
        }
    }
}
