package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/2
 */
public class ClassInitTest {
    private static int num = 1;
    static {
        num = 2;
        number = 20;
        System.out.println(num);
        //报错，非法的前向引用
        //System.out.println(number);
    }

    private static int number = 10;
    public static void main(String[] args) {
        // 2
        System.out.println(ClassInitTest.num);
        // 10
        System.out.println(ClassInitTest.number);
    }
}
