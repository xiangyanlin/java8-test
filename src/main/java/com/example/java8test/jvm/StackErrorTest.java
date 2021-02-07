package com.example.java8test.jvm;

import java.util.Date;

/**
 * @author XiangYanLin
 * @date 2021/2/4
 * 演示栈中的异常：StackOverflowError
 * 默认情况下 count:9868
 * 设置栈大小 -Xss256k count:2289
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    }
}
