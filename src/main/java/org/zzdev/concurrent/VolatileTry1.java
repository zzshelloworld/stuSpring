package org.zzdev.concurrent;


import java.util.ArrayList;
import java.util.List;

public class VolatileTry1 {

    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) {
            count = count + 1;
        }
    }

    public static void main(String[] args) {
        VolatileTry1 t = new VolatileTry1();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }
        // 这个地方为什么分开写
        threads.forEach(o->o.start());

        threads.forEach(o-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
