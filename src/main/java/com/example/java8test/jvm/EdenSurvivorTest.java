package com.example.java8test.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/2/22
 */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油！");
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
