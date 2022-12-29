package com.haven.leetcode.leetcode1195;

import java.util.concurrent.Semaphore;
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
 * Semaphore
 * */
public class FizzBuzz5 {
    private int n;

    private Semaphore number = new Semaphore(1);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);


    public FizzBuzz5(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.acquire();
                printBuzz.run();
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            number.acquire();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                number.release();
            } else if (i % 3 == 0 && i % 5 != 0) {
                fizz.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzz.release();
            } else {
                fizzbuzz.release();
            }
        }
    }

}
