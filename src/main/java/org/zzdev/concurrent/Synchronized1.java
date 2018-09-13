package org.zzdev.concurrent;

import org.junit.Test;

public class Synchronized1 {
    private int count = 10;
    private Object o = new Object();

    private void m() {
        // 对o加锁
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    private void m1() {
        //对本身加锁
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    private synchronized void m2() {
        //等同于对本身this加锁
        count--;
        System.out.println(Thread.currentThread().getName() + " count:" + count);
    }

    public  void mm() {
        synchronized(Synchronized1.class) {
            //考虑一下这里写synchronized(this)是否可以？(this=直接在方法上加入=xxx.class)??
            count --;
        }
    }

    public static void main(String[] args) {
//        m();
    }
    @Test
    public void testsync() {
        m2();
    }


}
