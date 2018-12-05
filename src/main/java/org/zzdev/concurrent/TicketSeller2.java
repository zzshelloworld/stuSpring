package org.zzdev.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TicketSeller2 {
    static Vector<String> list = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (list.size() > 0) {
                    // 判断和remove分离了，加上时间的间隔，来模拟判断中间被打断。
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("售出" + list.remove(0));
                }
            }).start();
        }

    }
}
