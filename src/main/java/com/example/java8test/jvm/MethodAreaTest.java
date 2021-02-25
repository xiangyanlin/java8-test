package com.example.java8test.jvm;

/**
 * non-final的类变量
 * @author XiangYanLin
 * @date 2021/2/25
 */
public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        order.hello();
        System.out.println(order.count);
    }
}
class Order {
    public static int count = 1;
    public static final int number = 2;
    public static void hello() {
        System.out.println("hello!");
    }
}