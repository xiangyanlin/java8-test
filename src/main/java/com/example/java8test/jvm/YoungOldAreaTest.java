package com.example.java8test.jvm;

import java.util.concurrent.TimeoutException;

/**
 * @author XiangYanLin
 * @date 2021/2/23
 * 测试：大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        //20m
        byte [] buffer=new byte[1021*1024*20];
    }

    public void method() throws TimeoutException {
        if(true){
            throw new TimeoutException();
        }
    }
}
