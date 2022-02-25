package com.mcc.g3n.demo.test;

/**
 * @author wb-yk935086
 * @date 2021/11/12
 */
public class SynchronizedDemo<T> {

    private T val;

    public synchronized void set(T newVal) {
        // System.out.println("oldVal:"+this.val+"----newVal:"+newVal);
        this.val = newVal;
        for (float i = 0 ; i < 1000000; i ++){
            i -= 0.5;
        }
    }

    public void get(){
        synchronized (this){
            System.out.println("get:  " + this.val);
            for (float i = 0 ; i < 1000000; i ++){
                i -= 0.5;
            }
        }
    }

}
