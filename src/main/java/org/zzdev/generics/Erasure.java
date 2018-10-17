package org.zzdev.generics;

/**
 * @author zhangzhe17848
 */
public class Erasure<T> {
    T object;

    public Erasure(T object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Erasure<String> erasure = new Erasure<String>("hello");
        Class eclz = erasure.getClass();
        System.out.println("erasure class is:" + eclz.getName());
    }

}