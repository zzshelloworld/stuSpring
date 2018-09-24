package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTry {
    AtomicInteger count = new AtomicInteger(0);

    void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicTry t = new AtomicTry();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            threads.add(new Thread(t::m));
        }
    }
}
