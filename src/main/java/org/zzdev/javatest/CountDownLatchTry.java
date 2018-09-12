package org.zzdev.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTry {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountDownLatchTry.class);

    private static void countDownLatch() throws Exception {
        int thread = 3;
        long start = System.currentTimeMillis();
        final CountDownLatch countDown = new CountDownLatch(thread);
        for (int i = 0; i < thread; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LOGGER.info("thread run");
                    try {
                        Thread.sleep(2000);
                        countDown.countDown();

                        LOGGER.info("thread end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        countDown.await();
        long stop = System.currentTimeMillis();
        LOGGER.info("main over total time={}", stop - start);
    }

    public static void main(String[] args) throws Exception {
        countDownLatch();
    }
}
