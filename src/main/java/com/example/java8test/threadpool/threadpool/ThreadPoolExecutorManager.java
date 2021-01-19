package com.example.java8test.threadpool.threadpool;

import com.example.java8test.enums.ThreadPoolType;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin.
 * @date 2020/12/28
 * 自定义线程池
 */
public class ThreadPoolExecutorManager {

    /**
     * cpu核
     */
    static final int N_CPUS = Runtime.getRuntime().availableProcessors();

    /**
     * 计算密集型
     */
    private static final int COUNT_CORE_POOL_SIZE=N_CPUS+1;

    /**
     * IO密集型
     */
    private static final int IO_CORE_POOL_SIZE=N_CPUS+1;

    /**
     * 核心线程数
     */
    private static  int CORE_POOL_SIZE=N_CPUS+1;

    /**
     * 最大线程数
      */
    private static final int MAX_POOL_SIZE = 25*N_CPUS;

    /**
     * 阻塞队列长度
     */
    private static final int QUEUE_CAPACITY = 100;

    /**
     * 存获时间
     */
    private static final int KEEP_ALIVE_TIME = 30;


    /**
     * 构建线程池
     * @param type
     * @return
     */
    public  static ThreadPoolExecutor newThreadPoolExecutor(ThreadPoolType type){
        //线程池分为io密集型和计算密集型
        if(ThreadPoolType.IO.equals(type)){
            //io密集型
            CORE_POOL_SIZE=IO_CORE_POOL_SIZE;
        }else{
            //计算密集型
            CORE_POOL_SIZE=COUNT_CORE_POOL_SIZE;
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
