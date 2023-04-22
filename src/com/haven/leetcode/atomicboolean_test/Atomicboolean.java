package com.haven.leetcode.atomicboolean_test;

import java.util.concurrent.atomic.AtomicBoolean;

public class Atomicboolean implements Runnable {
    private AtomicBoolean someone = new AtomicBoolean();

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (someone.compareAndSet(false, true)) {
            System.out.println(Thread.currentThread().getName()
                    + ": after judgment,the someone is " + someone);
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " i am coming");
            System.out.println(Thread.currentThread().getName()
                    + " i have to leaving");
            someone.set(false);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " i can't visit the house");
        }
    }

    public static void main(String[] args) {
        Atomicboolean ab=new Atomicboolean();
        new Thread(ab,"Thread_1").start();
        new Thread(ab,"Thread_2").start();
    }

}
