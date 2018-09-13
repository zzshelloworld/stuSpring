package org.zzdev.concurrent;

public class SyncMethod {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"m1 begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName()+"m1 begin");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end");
    }

    public static void main(String[] args) {
        // 注意这个对象,这个是关于 占用锁的,如果这个方法不是直接的实现runnable的，那么可以在runnable中调用
        SyncMethod t = new SyncMethod();
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();

//        new Thread(()->t.m1(), "t1").start();
//        new Thread(()->t.m2(), "t2").start();


//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				t.m1();
//			}
//
//		});


    }
}
