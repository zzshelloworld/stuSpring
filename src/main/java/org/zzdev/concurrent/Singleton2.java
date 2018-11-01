package org.zzdev.concurrent;

public class Singleton2 {
    private Singleton2(){

    }

    private static class Inner{
        private static Singleton2 s = new Singleton2();
    }

    public static Singleton2 getSingleton(){
        return Inner.s;
    }
}
