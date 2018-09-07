package org.zzdev.javatest;

public class WaitNotifyTry {
    private int number = 1;
    private boolean flag = false;

    public static void main(String[] args) {
        WaitNotifyTry number = new WaitNotifyTry();
        Thread t1 = new Thread(new jimetode(number));
        t1.setName("奇数");
        Thread t2 = new Thread(new oumetode(number));
        t2.setName("偶数");
        t1.start();
        t2.start();
    }

    private static class jimetode implements Runnable {
        private WaitNotifyTry number;

        public jimetode(WaitNotifyTry number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.number <= 100) {
                synchronized (WaitNotifyTry.class) {
                    if (number.flag) {
                        number.number++;
                        System.out.println(Thread.currentThread().getName() + "---" + number.number);
                        number.flag = false;
                        WaitNotifyTry.class.notify();
                    } else {
                        try {
                            WaitNotifyTry.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class oumetode implements Runnable {
        private WaitNotifyTry number;

        public oumetode(WaitNotifyTry number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.number <= 100) {
                synchronized (WaitNotifyTry.class) {
                    if (!number.flag) {
                        number.number++;
                        System.out.println(Thread.currentThread().getName() + "---" + number.number);
                        number.flag = true;
                        WaitNotifyTry.class.notify();
                    } else {
                        try {
                            WaitNotifyTry.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
