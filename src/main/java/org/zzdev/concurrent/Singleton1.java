package org.zzdev.concurrent;
// https://blog.csdn.net/u014672511/article/details/79774847
public class Singleton1 {
    static Singleton1 sin = new Singleton1();
    // 这个类只能有这一个对象
    // 防止其他类直接new 一个对象的实例
    private Singleton1() {}

    public static Singleton1 getSin() {
        return sin;
    }

}
