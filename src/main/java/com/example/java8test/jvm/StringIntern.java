package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/28
 */
public class StringIntern {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        // s3变量记录的地址是 new String("11")
        String s3 = new String("1") + new String("1");
        //这段代码执行完以后，常量池中不存在 "11"，
        //jdk6 在常量池中生成新的 "11"，
        //jdk7/8 此时常量中并没有创建"11”.而是创建一个指向堆空间中new String("11")的地址
        s3.intern();
        //s4变量记录的地址:使用的是上一行代码代码执行时，在常量池中生成的"11"的地址
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
