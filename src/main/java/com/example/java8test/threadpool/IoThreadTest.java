package com.example.java8test.threadpool;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/2/7
 */
public class IoThreadTest {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            16,
            16,
            30,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(16);
        //如果是1千万数据则循环1千次

        try {
            System.out.println(Thread.currentThread().getName()+"***");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
            System.out.println("本次写入结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
