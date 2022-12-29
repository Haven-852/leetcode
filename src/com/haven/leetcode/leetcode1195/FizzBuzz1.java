package com.haven.leetcode.leetcode1195;

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
* wait + notify
* */
public class FizzBuzz1 {
    private int n;
    private int i = 1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized(this){
            while(i <= n){
                if(i % 3 == 0 && i % 5 != 0){
                    printFizz.run();
                    i++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized(this){
            while(i <= n){
                if(i % 3 != 0 && i % 5 == 0){
                    printBuzz.run();
                    i++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized(this){
            while(i <= n){
                if(i % 3 == 0 && i % 5 == 0){
                    printFizzBuzz.run();
                    i++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized(this){
            while(i <= n){
                if(i % 3 != 0 && i % 5 != 0){
                    printNumber.accept(i);
                    i++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }
}
