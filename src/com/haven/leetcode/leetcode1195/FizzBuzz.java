package com.haven.leetcode.leetcode1195;

import java.util.function.IntConsumer;
/**
 * 1.synchrozied
 * 2.wait + notify
 * 3.ReentrantLock
 * 4.ReentrantLock + Condition
 * 5.Thread.yield()
 * 6.Semaphore
 * 7.BlockingQueue
 * 8.CyclicBarrier
 *其中：方法3和1类似，方法4和2类似，方法7和6类似。
 * 利用synchrozied来实现多线程
 * 两篇解释
 * 1、https://blog.csdn.net/Pomel0/article/details/99818556?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167228539316782427423198%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167228539316782427423198&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-99818556-null-null.142^v68^control,201^v4^add_ask,213^v2^t3_esquery_v1&utm_term=Java%20synchrozied&spm=1018.2226.3001.4187
 * 2、https://blog.csdn.net/weixin_45649283/article/details/105536440?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167228539316782427423198%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167228539316782427423198&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-105536440-null-null.142^v68^control,201^v4^add_ask,213^v2^t3_esquery_v1&utm_term=Java%20synchrozied&spm=1018.2226.3001.4187
 *
 */
public class FizzBuzz {
    private int n;
    private int i=1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i<=n){
            synchronized (this){
                if (i<=n){
                    if (i%3==0&&i%5!=0){
                        printFizz.run();
                        i++;
                    }
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i<=n){
            synchronized (this){
                if (i<=n){
                    if (i%3!=0&&i%5==0){
                        printBuzz.run();
                        i++;
                    }
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i<=n){
            synchronized (this){
                if (i<=n){
                    if (i%3==0&&i%5==0){
                        printFizzBuzz.run();
                        i++;
                    }
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i<=n){
            synchronized (this){
                if (i<=n){
                    if (i%3!=0&&i%5!=0){
                        printNumber.accept(i);
                        i++;
                    }
                }
            }
        }
    }
}
