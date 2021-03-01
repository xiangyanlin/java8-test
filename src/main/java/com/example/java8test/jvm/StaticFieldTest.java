package com.example.java8test.jvm;

import java.util.concurrent.TimeUnit;

/**
 * 静态引用对应的对象实体始终都存在堆空间
 * jdk7:-Xms200m -Xmx200m -XX:PermSize=300m -XX:MaxPermSize=300m
 * jdk8:-Xms200m -Xmx200m -XX:MetaspceSize=300m -XX:MaxMetaspceSize=300m
 * @author XiangYanLin
 * @date 2021/2/26
 */
public class StaticFieldTest {
    /**
     * 100MB
     * 静态引用对应的对象实体始终都存在堆空间
     */
    private static  byte [] arr = new byte[1021*1024*100];

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.arr);
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
