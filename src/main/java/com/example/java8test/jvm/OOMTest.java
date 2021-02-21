package com.example.java8test.jvm;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author XiangYanLin
 * @date 2021/2/21
 */
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list=new ArrayList<>(10);
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024*1024)));
        }
    }
}

class Picture {
    private byte[] pixels;
    public Picture(int length){
        this.pixels=new byte[length];
    }
}

