package com.example.java8test.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/2/2
 */
public class HelloApp {
    /**
     * 准备阶段为0，在下个阶段，也就是初始化的时候才是1
      */
    private static int a = 1;

    public static void main(String[] args) {
        System.out.println("123");
        try {
            TimeUnit.SECONDS.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
