package com.example.java8test;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author XiangYanLin.
 * @Date Created in 13:46 2020/12/3
 * @Description：
 */
@RestController
public class ThreadDemo implements Runnable {

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    ExecutorService threadPool = new ThreadPoolExecutor(
            2,
            5,
            1L,
            TimeUnit.SECONDS,
            //存放提交但未执行任务的队列
            new LinkedBlockingQueue<>(3),
            //创建线程的工厂类
            Executors.defaultThreadFactory(),
            //等待队列满后的拒绝策略
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws InterruptedException {

        ThreadDemo obj = new ThreadDemo();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
        //Thread thread = new Thread();
        //testPool();
        //thread.start();
//        thread.wait();
//        thread.wait(1000);
//        Thread.sleep(1000);
        //Strings.isNullOrEmpty("");
    }

    @RequestMapping("/testPool")
    public void testPool() {
        int j = 0;
        for (int i = 0; i < 3; i++) {
            j++;
            final int[] finalJ = {j};
            threadPool.execute(() -> {
                finalJ[0] = finalJ[0] + 1;
                System.out.println("newThread:" + finalJ[0]);
            });
            threadPool.execute(() -> System.out.println("otherThread:" + finalJ[0]));

        }

    }

    public void testThreadLocal() {

    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName()
                + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= " + Thread.currentThread().getName()
                + " formatter = " + formatter.get().toPattern());
    }
}

