package com.haven.leetcode.leetcode1195;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/* * 1.synchrozied
 * * 2.wait + notify
 * 3.ReentrantLock
 * 4.ReentrantLock + Condition
 * 5.Thread.yield()
 * 6.Semaphore
 * 7.BlockingQueue
 * 8.CyclicBarrier
 *其中：方法3和1类似，方法4和2类似，方法7和6类似。
 * ReentrantLock
 * */
public class FizzBuzz2 {
    private int n;
    private volatile int i = 1;
    private Lock lo = new ReentrantLock();

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n){
            lo.lock();
            try{
                if(i <= n){
                    if(i % 3 == 0 && i % 5 != 0){
                        printFizz.run();
                        i++;
                    }
                }
            }finally{
                lo.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n){
            lo.lock();
            try{
                if(i <= n){
                    if(i % 3 != 0 && i % 5 == 0){
                        printBuzz.run();
                        i++;
                    }
                }
            }finally{
                lo.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n){
            lo.lock();
            try{
                if(i <= n){
                    if(i % 3 == 0 && i % 5 == 0){
                        printFizzBuzz.run();
                        i++;
                    }
                }
            }finally{
                lo.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n){
            lo.lock();
            try{
                if(i <= n){
                    if(i % 3 != 0 && i % 5 != 0){
                        printNumber.accept(i);
                        i++;
                    }
                }
            }finally{
                lo.unlock();
            }
        }
    }
}
