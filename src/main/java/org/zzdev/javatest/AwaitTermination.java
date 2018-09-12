package org.zzdev.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AwaitTermination {
    // 通过awaitTermination 让主线程等待线程池内的任务执行完成
    private static final Logger LOGGER = LoggerFactory.getLogger(AwaitTermination.class);
    private static void executorService() throws Exception{
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10) ;
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,5,1, TimeUnit.MILLISECONDS,queue) ;
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("running");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("running2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        poolExecutor.shutdown();
        while (!poolExecutor.awaitTermination(1,TimeUnit.SECONDS)){
            LOGGER.info("线程还在执行。。。");
        }
        LOGGER.info("main over");
    }

    public static void main(String[] args) throws Exception {
        executorService();
    }
}
