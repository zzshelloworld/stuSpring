package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketSeller3 {
    private static List<String> list = new LinkedList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
        }
    }
    // 有序了
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (list) {
                        if (list.size() <= 0) {
                            break;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("售出了" + list.remove(0));
                    }
                }
            }).start();
        }

    }

}
