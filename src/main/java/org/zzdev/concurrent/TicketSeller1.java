package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;

public class TicketSeller1 {
    private static List<String> list = new ArrayList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
        }
    }

    // 没看出什么奇怪的。
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (list.size() > 0) {
                    System.out.println("售出" + list.remove(0));
                }
            }).start();
        }

    }
}
