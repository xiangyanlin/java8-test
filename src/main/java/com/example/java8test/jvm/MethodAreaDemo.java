package com.example.java8test.jvm;

import java.util.concurrent.TimeUnit;

/**
 * 测试设置方法区大小参数的默认值
 * jdk7:-XX:PermSize=100m
 * jdk8:-XX:MetaspceSize=100m -XX:MaxMetaspceSize=100m
 * @author XiangYanLin
 * @date 2021/2/25
 */
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start..");
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end..");
    }
}
