package com.example.java8test.jvm;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author XiangYanLin
 * @date 2021/2/22
 */
public class HeapInstanceTest {
    byte [] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
            Thread.sleep(10);
        }
    }
}
