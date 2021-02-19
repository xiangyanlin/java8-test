package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/7
 */
public class DynamicLikingTest {

    int number = 10;

    public void methodA(){
        System.out.println("methodA()****");
    }

    public void methodB(){
        System.out.println("methodB*****");
        methodA();
        number++;
    }
}
