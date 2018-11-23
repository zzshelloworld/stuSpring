package org.zzdev.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSeller4 {
    static Queue<String> ticks = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            ticks.add(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String tick = ticks.poll();
                    if (tick == null) {
                        break;
                    } else {
                        System.out.println("售出 " + tick);
                    }
                }
            }).start();
        }
    }
}
