package com.zhangzhe.tryjava;

public class AboutString {
    public static void main(String[] args){
        String a = "12##34####";
        String[] arr = a.split("##");
        String b = "";
        System.out.println(b.replaceAll("##","@@") + "11");
        System.out.println(arr.length);
        for (String aa : arr) {
            System.out.println(aa + "1");
        }
    }
}
