package com.example.java8test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiangYanLin
 * @date 2021/2/23
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "test";
            while(true) {
                list.add(a);
                a = a + a;
                i++;
            }
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println("遍历次数为:" + i);
        }
    }
}
