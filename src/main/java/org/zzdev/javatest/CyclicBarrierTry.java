package org.zzdev.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTry {
    private static final Logger LOGGER = LoggerFactory.getLogger(CyclicBarrierTry.class);

    private static void cyclicBarrier() throws Exception {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("thread run");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                LOGGER.info("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("thread run");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                LOGGER.info("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("thread run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                LOGGER.info("thread end do something");
            }
        }).start();

        LOGGER.info("main thread");
    }

    public static void main(String[] args) throws Exception {
        cyclicBarrier();
    }
}
