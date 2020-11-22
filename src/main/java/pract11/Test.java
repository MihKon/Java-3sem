package pract11;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    //static int op = new Random().nextInt(2020)+200;
    static int totalSum1 = 0;
    static AtomicInteger totalSum2 = new AtomicInteger();
    static ReentrantLock lock = new ReentrantLock();
    static int totalSum3 = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            final int i1 = i;
            Thread thread = new Thread(() -> doWork(i1));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("TOTAL: " + (end - start));
        System.out.println("TOTAL SUM WITH LOCK: " + totalSum1);
        System.out.println("ATOMIC INTEGER TOTAL SUM: " + totalSum2.get());
        System.out.println("TOTAL SUM WITH SYNCHRONIZED: " + totalSum3);
    }

    private static void doWork(int i) {
        int op = 2020;
        long start = System.currentTimeMillis();
        long result = doSomeWork(i * 1000, op * 10_1_00);
        long end = System.currentTimeMillis();
        System.out.println(i + ": " + result + " time: " + (end - start));
    }

    private static long doSomeWork(int operand, int count) {
        long res = 0;
        for (int i = 0; i < count; i++) {
            res += (operand + i) * (operand + i) * (Math.sqrt(operand + i) + Math.PI);
            incSum1();
            incSum2();
            incSum3();
        }
        return res;
    }

    private static void incSum1(){
        lock.lock();
        totalSum1++;
        lock.unlock();
    }

    private static void incSum2(){
        totalSum2.incrementAndGet();
    }
    private synchronized static void incSum3(){
        totalSum3++;
    }
}
