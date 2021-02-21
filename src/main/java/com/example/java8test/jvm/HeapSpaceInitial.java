package com.example.java8test.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/2/21
 *
 * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
 * -X：是jvm运行参数
 * ms：memory start
 * -Xmx：用来设置堆空间（年轻代+老年代）的最大内存大小
 * 开发中建议将初始堆内存和最大堆内存设置成相同的值
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        // 返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回Java虚拟机试图使用的最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms:" + initialMemory + "M");
        System.out.println("-Xmx:" + maxMemory + "M");

//        System.out.println("系统内存大小为:" + initialMemory *64.0/1024+ "G");
//        System.out.println("系统内存大小为:" + maxMemory*4.0/1024 + "G");

//        try {
//            TimeUnit.SECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
