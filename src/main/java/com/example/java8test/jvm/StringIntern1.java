package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/28
 */
public class StringIntern1 {
    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");
        String s4 = "11"; // 在常量池中生成的对象"11"
        s3.intern();
        System.out.println(s3 == s4);
    }
}
