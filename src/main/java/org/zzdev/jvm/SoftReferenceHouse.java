package org.zzdev.jvm;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceHouse {
    public static void main(String[] args) {
        // 
        List<SoftReference> houses = new ArrayList<>();
        int i = 0;
        while (true) {
            SoftReference<House> buyer2 = new SoftReference<House>(new House());
            houses.add(buyer2);
            System.out.println("i=" + (++i));
        }
    }
}

class House {
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];

    class Door {
    }
}