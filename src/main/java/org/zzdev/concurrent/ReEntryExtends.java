package org.zzdev.concurrent;

import java.util.concurrent.TimeUnit;
//??子类调用父类的同步方法
public class ReEntryExtends {
    synchronized void m() {
        System.out.println("m begin");
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new TT().m();
        System.out.println("m end");
    }
    public static void main(String[] args) {
//        new TT().m();
        new ReEntryExtends().m();
    }

}

class TT extends ReEntryExtends {
    @Override
    synchronized void m() {
        System.out.println("child m begin");
//        super.m();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("child m end");
    }
}
