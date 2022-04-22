package com.mcc.g3n.demo.test;


import java.util.concurrent.TimeUnit;

public class TestVolatile {
    static boolean flag = true;

    public static void main(String[] args) throws Exception{
        new Thread(() -> {
            while (flag) {
                // 加上 System.out.println 就无法验证了！！
            }
        }).start();
        // JVM 的 JIT 编译器会把热点代码(执行频率高)拷贝到工作内存中，不再每次从主存读取
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("flag change to false");
        flag = false;
    }
}
