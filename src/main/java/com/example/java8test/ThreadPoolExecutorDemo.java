package com.example.java8test;

import com.example.java8test.enums.ThreadPoolType;
import com.example.java8test.threadpool.threadpool.ThreadPoolExecutorManager;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author XiangYanLin.
 * @date 2020/12/15
 */
public class ThreadPoolExecutorDemo {


    public static void main(String[] args) {
        ThreadPoolExecutor executor
                = ThreadPoolExecutorManager.newThreadPoolExecutor(ThreadPoolType.IO);
        System.out.println("Finished all threads");
    }

}
