package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;
// 区别不明显
public class VolatileTry {
    volatile boolean running = true;

    void m() {
        System.out.println("m running");
        while (running) {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            // 在死循环中有空闲的时候可能，回去主内存去读缓存
        }
        System.out.println("m stop");
    }

    public static void main(String[] args) {
        VolatileTry v = new VolatileTry();
        new Thread(v::m, "v1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.running = false;
    }
}
