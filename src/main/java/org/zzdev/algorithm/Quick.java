package org.zzdev.algorithm;

import static jdk.nashorn.internal.objects.Global.print;

public class Quick {
    public void sort(int[] arr) {
        int key = arr[0];
        int l = 1;
        int h = arr.length;
        int temp;
        while (l < h) {
            if (arr[l] > key) {
                if (arr[h] < key) {
                    temp = arr[l];
                    arr[l] = arr[h];
                    arr[h] = temp;
                    l++;
                    h--;
                } else {
                    h--;
                }
            } else {
                l++;
            }
        }
        arr[0] = arr[l];
        arr[l] = key;

//        sort(a)
    }
}