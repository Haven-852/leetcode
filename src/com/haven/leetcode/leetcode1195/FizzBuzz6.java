package com.haven.leetcode.leetcode1195;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
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
 * BlockingQueue
 * */
public class FizzBuzz6 {
    private int n;

    private BlockingQueue<Integer> number = new LinkedBlockingQueue<Integer>(1){{
        offer(0);
    }};
    private BlockingQueue<Integer> fizz = new LinkedBlockingQueue<Integer>(1);
    private BlockingQueue<Integer> buzz = new LinkedBlockingQueue<Integer>(1);
    private BlockingQueue<Integer> fizzbuzz = new LinkedBlockingQueue<Integer>(1);


    public FizzBuzz6(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.take();
                printFizz.run();
                number.put(0);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.take();
                printBuzz.run();
                number.put(0);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.take();
                printFizzBuzz.run();
                number.put(0);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            number.take();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                number.put(0);
            } else if (i % 3 == 0 && i % 5 != 0) {
                fizz.put(0);
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzz.put(0);
            } else {
                fizzbuzz.put(0);
            }
        }
    }

}
