package com.example.java8test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XiangYanLin.
 * @date 2020/12/15
 */
public class TestAtomicClass {

    private AtomicInteger count = new AtomicInteger();

    //使用AtomicInteger之后，不需要对该方法加锁，也可以实现线程安全。
    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

}
