package com.example.java8test.jvm;

/**
 * 面试题：new String("ab")会创建几个对象？2个 new堆中创建一个，字符串常量池中一个。字节码指令ldc
 * new String("a")+new String("b")呢？
 * @author XiangYanLin
 * @date 2021/2/28
 */
public class StringNewTest {
    public static void main(String[] args) {
        //String str = new String("ab");
        String str = new String("a") + new String("b");
    }
}
