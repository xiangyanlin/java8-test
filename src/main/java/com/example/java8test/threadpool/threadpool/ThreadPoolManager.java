package com.example.java8test.threadpool.threadpool;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XiangYanLin
 * @date 2021/2/22
 * 线程池管理
 */
public class ThreadPoolManager {
    private static final String THREAD_NAME_COMMON = "threadPool-common";

    /**
     * 普通线程池
     */
    private ThreadPoolExecutor mPoolExecutor;

    /**
     * 普通线程池任务队列-二级队列
     */
    private HashMap<Integer, HashMap<String, LinkedBlockingQueue<Runnable>>> mTaskMapQueue =
            new HashMap<>();

    /**
     * 任务提交到线程池的任务集合
     */
    private Map<String, List<WeakReference<Future<?>>>> mTaskMap;

    /**
     * 单例
     */
    private static ThreadPoolManager instance = null;

    /**
     * 普通线程池核心线程池的数量，同时能够执行的线程数量
     */
    private int mCommonCorePoolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;

    /**
     * 非核心线程数
     */
    private int mNonCorePoolSize = 10;
    /**
     * 最大线程池数量
     */
    private int mMaximumPoolSize = mCommonCorePoolSize + mNonCorePoolSize;

    /**
     * 低优先级任务不占用线程数
     * mMaximumPoolSize > mCommonCorePoolSize
     */
    private int mSpareThreadSize = 5;

    /**
     * 存活时间,根据各种线程任务执行超时时间评估 （网络重连任务 超时）
     */
    private long mKeepAliveTime = 30;
    /**
     * 线程池任务队列
     */
    private final int MAX_QUEUE_LENGTH = 200;

    private long mRejectCount = 0;

    private LinkedBlockingQueue<Runnable> mQueue =
            new LinkedBlockingQueue<Runnable>(MAX_QUEUE_LENGTH);

    /**
     * 创建一个新的实例 ThreadPoolManager
     */
    private ThreadPoolManager() {
        mPoolExecutor = new ThreadPoolExecutor(
                mCommonCorePoolSize,
                mMaximumPoolSize,
                mKeepAliveTime,
                TimeUnit.SECONDS,
                //缓冲队列，用于存放等待任务，Linked的先进先出
                mQueue,
                //创建线程的工厂
                new ThreadFactory() {
                    private final AtomicInteger mCount = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, THREAD_NAME_COMMON + "#" + mCount.getAndIncrement());
                    }
                }
        );
        // 用来对超出maximumPoolSize的任务的处理策略
        mPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                mRejectCount++;
                System.out.println("ThreadPoolManager rejectedExecution happaned mRejectCount=" +
                        mRejectCount);
                ThreadPoolManager.getInstance().addCommonTask("", r, Thread.NORM_PRIORITY);
            }
        });

        mTaskMap = new WeakHashMap<String, List<WeakReference<Future<?>>>>();

        mPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int available = mMaximumPoolSize - mPoolExecutor.getActiveCount();
                        // 线程池队列满了不调度
                        if (mQueue.size() >= MAX_QUEUE_LENGTH) {
                            continue;
                        }
                        // 调度策略 根据任务的优先级进行调度,高优先级任务优先调度
                        for (Integer p = Thread.MAX_PRIORITY; p > Thread.MIN_PRIORITY; p--) {
                            // 如果优先级小于5的线程(低优先级)来了，空闲线程太少，不调度
                            if (p < Thread.NORM_PRIORITY &&
                                    available < mSpareThreadSize) {
                                System.out
                                        .println("available = " + available + " mMaximumPoolSize=" +
                                                mMaximumPoolSize);
                                break;
                            }
                            HashMap<String, LinkedBlockingQueue<Runnable>> mapQueue =
                                    mTaskMapQueue.get(p);
                            if (mapQueue == null) {
                                continue;
                            }
                            if (!mapQueue.isEmpty()) {
                                Set<String> taskKeySet = mapQueue.keySet();
                                Iterator<String> subIterator = taskKeySet.iterator();
                                if (subIterator.hasNext()) {
                                    String taskName = subIterator.next();
                                    LinkedBlockingQueue<Runnable> queue = mapQueue.get(taskName);
                                    if (!queue.isEmpty()) {
                                        try {
                                            Runnable runnable = queue.take();
                                            ThreadPoolManager.getInstance()
                                                    .submitTask(runnable, taskName);
                                            // 正常调度了一个任务，重新遍历寻找高优先级任务
                                            break;
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                            break;
                                        }
                                    }
                                }
                            }
                            // 没有找到任务，继续找任务
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 根据优先级加入二级队列
     *
     * @param taskName 任务名称
     * @param task     任务
     * @param priority 任务优先级
     * @throws NullPointerException
     */
    public synchronized void addCommonTask(String taskName, Runnable task, int priority) throws
            NullPointerException {
        if (priority > Thread.MAX_PRIORITY || priority < Thread.MIN_PRIORITY) {
            throw new IllegalArgumentException(
                    "priority must be  between " + Thread.MIN_PRIORITY + " and " +
                            Thread.MAX_PRIORITY);
        }

        if (taskName == null) {
            throw new NullPointerException("taskName can not be null");
        }
        HashMap<String, LinkedBlockingQueue<Runnable>> mapQueue = mTaskMapQueue.get(priority);
        if (mapQueue == null) {
            mapQueue = new HashMap<String, LinkedBlockingQueue<Runnable>>(16);
            LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
            mapQueue.put(taskName, queue);
        }
        LinkedBlockingQueue<Runnable> queue = mapQueue.get(taskName);
        queue.add(task);
        mTaskMapQueue.put(priority, mapQueue);
    }

    /**
     * 获取ThreadPoolManager单例对象
     */
    public static ThreadPoolManager getInstance() {
        if (instance == null) {
            synchronized (ThreadPoolManager.class) {
                if (instance == null) {
                    instance = new ThreadPoolManager();
                }
            }
        }
        return instance;
    }

    /**
     * 释放MinaThreadPoolManager中线程资源
     * 主要用于退出应用进程前，销毁线程池
     */
    public void release() {
        synchronized (ThreadPoolManager.class) {
            if (instance != null) {
                instance.cancelAllTaskThreads();
            }
            mPoolExecutor.shutdownNow();
            instance = null;
        }
    }

    /**
     * 将线程任务放到二级任务队列
     *
     * @param task 任务线程
     * @param name 任务名字
     */
    public void startTaskThread(Runnable task, String name) {
        if (task != null && name != null) {
            addCommonTask(name, task, Thread.NORM_PRIORITY);
        }
    }

    /**
     * 将线程任务放到二级任务队列
     *
     * @param task 任务线程
     * @param name 任务名字
     */
    public void startTaskThread(Runnable task, String name, int priority) {
        if (task != null && name != null) {
            addCommonTask(name, task, priority);
        }
    }

    /**
     * 开启线程
     *
     * @param task 任务线程
     * @param name 任务名字
     */
    public void submitTask(Runnable task, String name) {
        if (task != null && name != null) {
            Future<?> request = mPoolExecutor.submit(task);
            addTask(request, name);
            printPoolExecutorInfo();
        }
    }

    /**
     * 开启线程
     *
     * @param task 任务线程
     */
    @Deprecated
    public void executeTaskThread(Thread task) {
        String taskName = task.getName();
        System.out.println("ThreadPoolManager executeTaskThread task name = " + taskName);
        printPoolExecutorInfo();
        mPoolExecutor.execute(task);
    }

    /**
     * 结束线程
     *
     * @param task 任务线程
     */
    public void stopTaskThread(Thread task) {
        stopTaskThread(task.getName());
    }

    /**
     * 结束线程
     *
     * @param taskTag 任务线程
     */
    public void stopTaskThread(String taskTag) {
        cancelTaskThreads(taskTag);
    }

    /**
     * 添加执行任务到队列中
     *
     * @param request
     */
    private void addTask(Future<?> request, String taskTag) {
        synchronized (ThreadPoolManager.class) {
            if (taskTag != null) {
                List<WeakReference<Future<?>>> requestList = mTaskMap.get(taskTag);
                if (requestList == null) {
                    requestList = new LinkedList<WeakReference<Future<?>>>();
                    mTaskMap.put(taskTag, requestList);
                }
                requestList.add(new WeakReference<Future<?>>(request));
            }
        }
    }

    /**
     * 取消所有的任务
     */
    public void cancelAllTaskThreads() {
        for (String clsName : mTaskMap.keySet()) {
            List<WeakReference<Future<?>>> requestList = mTaskMap.get(clsName);
            if (requestList != null) {
                Iterator<WeakReference<Future<?>>> iterator = requestList.iterator();
                while (iterator.hasNext()) {
                    Future<?> request = iterator.next().get();
                    if (request != null) {
                        request.cancel(true);
                    }
                }
            }
        }
        mTaskMap.clear();
    }

    /**
     * 根据特定任务名称取消任务
     */
    private void cancelTaskThreads(String taskName) {
        System.out.println("ThreadPoolManager cancelTaskThreads task name = " + taskName);
        // 二级队列
        for (Integer p = Thread.MAX_PRIORITY; p > Thread.MIN_PRIORITY; p--) {
            HashMap<String, LinkedBlockingQueue<Runnable>> mapQueue =
                    mTaskMapQueue.get(p);
            if (mapQueue != null) {
                LinkedBlockingQueue<Runnable> queue = mapQueue.get(taskName);
                if (queue != null) {
                    queue.clear();
                }
            }
        }
        // 一级队列
        List<WeakReference<Future<?>>> requestList = mTaskMap.get(taskName);
        if (requestList != null) {
            Iterator<WeakReference<Future<?>>> iterator = requestList.iterator();
            while (iterator.hasNext()) {
                Future<?> request = iterator.next().get();
                if (request != null) {
                    request.cancel(true);
                }
            }
            mTaskMap.remove(taskName);
        }
        printPoolExecutorInfo();
    }

    public ThreadPoolExecutor getPoolExecutor() {
        return mPoolExecutor;
    }

    private void printPoolExecutorInfo() {
        if (mPoolExecutor != null) {
            System.out.println(
                    "ThreadPoolManager mPoolExecutor info:[poolSize:" + mPoolExecutor.getPoolSize()
                            + "，activeCount:" + mPoolExecutor.getActiveCount()
                            + "，taskQueueCount:" + mPoolExecutor.getQueue().size()
                            + "，completeTaskCount：" + mPoolExecutor.getCompletedTaskCount() + "]");
        }
    }

    /**
     * 任务队列中是否有
     *
     * @param task 任务
     * @return 是否有标签任务 true-有
     */
    public boolean hasTask(Thread task) {
        if (task == null) {
            return false;
        }
        return hasTask(task.getName());
    }

    /**
     * 任务队列中是否有
     *
     * @param taskTag 任务标签
     * @return 是否有标签任务 true-有
     */
    public boolean hasTask(String taskTag) {
        if (taskTag == null) {
            return false;
        }
        List<WeakReference<Future<?>>> requestList = mTaskMap.get(taskTag);
        if (requestList != null) {
            Iterator<WeakReference<Future<?>>> iterator = requestList.iterator();
            while (iterator.hasNext()) {
                Future<?> request = iterator.next().get();
                if (request != null) {
                    if (request.isCancelled()) {
                        System.out.println(
                                "ThreadPoolManager taskTag: " + taskTag + " has canceled ");
                        continue;
                    }
                    if (!request.isDone()) {
                        System.out.println("ThreadPoolManager hasTask " + taskTag);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
