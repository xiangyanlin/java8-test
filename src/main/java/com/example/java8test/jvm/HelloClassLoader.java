package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/1/22
 * 类加载器
 */
public class HelloClassLoader {
    public static void main(String[] args) {
        Object object=new Object();
        System.out.println(object.getClass().getClassLoader());

        HelloClassLoader hello=new HelloClassLoader();
        System.out.println(hello.getClass().getClassLoader().getParent().getParent());
        System.out.println(hello.getClass().getClassLoader().getParent());
        System.out.println(hello.getClass().getClassLoader());

    }
}
