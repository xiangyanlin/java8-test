package com.example.java8test.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/2/21
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            TimeUnit.SECONDS.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end....");
    }
}
