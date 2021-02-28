package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/28
 */
public class StringTest5 {
    public static void main(String[] args) {
        //test1();
        test6();
    }

    public static void test1() {
        // 得到 abc的常量池
        String s1 = "a" + "b" + "c";
        // abc存放在常量池，直接将常量池的地址返回
        String s2 = "abc";
        /**
         * 最终java编译成.class，再执行.class
         */
        // true，因为存放在字符串常量池
        System.out.println(s1 == s2);
        // true
        System.out.println(s1.equals(s2));
    }

    public static void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        // 如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        // 判断字符串常量池中是否存在JavaEEhadoop值，如果存在则返回常量池中的值，否则就在常量池中创建
        String s8 = s6.intern();
        System.out.println(s3 == s8); // true
    }

    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    public static void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    public static void test6() {
        long start = System.currentTimeMillis();
        method2(100000);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为: "+(end-start));
    }

    public static void method1(int highLevel) {
        String src = "";
        for (int i = 0; i < highLevel; i++) {
            // 每次循环都会创建一个StringBuilder对象
            src += "a";
        }
    }

    public static void method2(int highLevel) {
        StringBuilder sb = new StringBuilder(highLevel);
        for (int i = 0; i < highLevel; i++) {
            sb.append("a");
        }
    }
}
