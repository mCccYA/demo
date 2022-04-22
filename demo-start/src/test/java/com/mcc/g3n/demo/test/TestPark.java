package com.mcc.g3n.demo.test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class TestPark {

    @Test
    @SneakyThrows
    public void test() {
        Thread t = new Thread(()-> {
            log.debug("parke");
            LockSupport.park(this);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("interrupt status : {}", Thread.interrupted());
        }, "park-thread");
        t.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        log.debug("unpark");
        LockSupport.unpark(t);
        log.debug("t is interrupted: {}", t.isInterrupted());
        t.join();
    }

    @Test
    @SneakyThrows
    public void testInterrupt() {
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println("t1");
            }
            System.out.println("t1 isInterrupted: " + Thread.currentThread().isInterrupted() );
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            while (!Thread.interrupted()) {
//                System.out.println("t2");
            }
            System.out.println("t2 isInterrupted: " + Thread.interrupted() );
        }, "t2");
        t2.start();

        Thread t3 = new Thread(() -> {
            log.debug("t3 park");
            LockSupport.park(this);
            while (true) {
                if(Thread.interrupted()) {
                    log.debug("t3 isInterrupted");
                }
            }
        }, "t3");
//        t3.start();

        Thread t4 = new Thread(() -> {
            log.debug("t4 park");
            LockSupport.park(this);
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("t4 unpark");
            }
            log.debug("t4 isInterrupted");
        }, "t4");
        t4.start();

        Thread.sleep(100);
        t1.interrupt();
        t2.interrupt();
        Thread.sleep(3000);
//        t3.interrupt();
        LockSupport.unpark(t4);  // uppark 不会改变 interrupt 状态
        t4.join();
    }

}
