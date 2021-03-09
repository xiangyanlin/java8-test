package com.example.java8test.jvm;

/**
 * System.gc()
 * @author XiangYanLin
 * @date 2021/3/2
 */
public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        // 提醒JVM进行垃圾回收，但是不确定是否会执行
        System.gc();
        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 执行了 finalize方法");
    }
}
