package com.haven.leetcode.atomicboolean_test;

public class Visit implements Runnable {
    private boolean someone=false;

    public void run(){
        if (someone == false) {
            try {
                Thread.sleep(1 * 1000);
                someone = true;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " i am coming");
            System.out.println(Thread.currentThread().getName()
                    + " i have to leaving");
            someone = false;
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " i can't visit the house");
        }
    }

    public static void main(String[] args) {
        Visit vs=new Visit();
        new Thread(vs,"thread_1").start();
        new Thread(vs,"thread_2").start();
    }
}
