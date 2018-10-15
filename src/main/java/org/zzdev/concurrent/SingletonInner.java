package org.zzdev.concurrent;

import java.util.Arrays;

public class SingletonInner {
    private SingletonInner() {

    }

    private static class Inner {
        private static SingletonInner sin = new SingletonInner();
    }

    // 静态的原因是 其他类不能new 出这个类， 如果这个方法是静态的，就可以直接调用。
    public static SingletonInner getSin() {
        return Inner.sin;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                System.out.println(SingletonInner.getSin());
            });
        }

        Arrays.asList(ths).forEach(o -> o.start());
    }
}
