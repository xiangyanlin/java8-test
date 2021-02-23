package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/23
 */
public class ScalarReplace {
    public static class User {
        public int id;
        public String name;
    }

    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "test";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + "ms");
    }
}
