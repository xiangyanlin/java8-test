package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/28
 */
public class StringExer1 {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");
        String s2 = s.intern();
        System.out.println(s2 == "ab"); // jdk6:true jdk7/8 true
        System.out.println(s == "ab"); // jdk6:fasle jdk7/8 true
    }
}
