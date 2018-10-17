package org.zzdev.generics;

import java.util.ArrayList;
import java.util.List;

// https://blog.csdn.net/briblue/article/details/76736356
public class Test1 {
    // 类型擦除？？
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());
    }
}
