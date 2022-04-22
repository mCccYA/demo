package com.mcc.g3n.demo.test;

import lombok.SneakyThrows;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class MccTest {

    /**
     * 偏向锁 Mark word 测试
     */
    @Test
    @SneakyThrows
    public void testBaised() {
        BaisedObj obj = new BaisedObj();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

    public static void main(String[] args) throws Exception{
        BaisedObj obj = new BaisedObj();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        TimeUnit.SECONDS.sleep(4);
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

//        synchronized (obj) {
//            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
//        }
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

   static class BaisedObj { private int i; }

}
