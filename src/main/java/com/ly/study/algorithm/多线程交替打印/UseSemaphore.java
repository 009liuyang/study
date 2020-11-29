package com.ly.study.algorithm.多线程交替打印;

import java.util.concurrent.Semaphore;

/**
 * @describe
 * @author yang.liu
 * @date 2020-04-08
 */
public class UseSemaphore {

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}

class PrintABC {
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);


    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    private void print(String name, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        for (int i = 0; i < 10; i++) {
            try {
                currentSemaphore.acquire();
                System.out.println(Thread.currentThread().getName() +" print "+ name);
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
