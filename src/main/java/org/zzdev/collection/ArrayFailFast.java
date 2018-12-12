package org.zzdev.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayFailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
