package org.zzdev.concurrent;


import java.util.ArrayList;
import java.util.List;

public class VolatileTry2 {

    int count = 0;

    synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count = count + 1;
        }
    }

    public static void main(String[] args) {
        VolatileTry2 t = new VolatileTry2();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }
        // 这个地方为什么分开写
        threads.forEach(Thread::start);

        threads.forEach(o-> {
            try {
                o.join();
                // 谁调用谁等待，main线程就会去等待这里所有的线程完成后，运行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
