package com.example.java8test.jvm;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * 直接内存
 *
 * @author XiangYanLin
 * @date 2021/2/26
 */
public class BufferTest {
    /**
     * 1GB
     */
    private static final int BUFFER = 1024 * 1024 * 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完成,请求指示");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放！");
        byteBuffer = null;
        System.gc();
        scanner.next();

    }
}
