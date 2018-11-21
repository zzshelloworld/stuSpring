package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTry {
    AtomicInteger count = new AtomicInteger(0);

    void m(){
        for (int i = 0; i < 10000; i++) {
//            if (count.get() <200000)
            count.incrementAndGet();
//            count.set(count.get() + 1);
        }
    }

    public static void main(String[] args) {
        AtomicTry t = new AtomicTry();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            threads.add(new Thread(t::m));
        }

        threads.forEach(o -> o.start());
        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
