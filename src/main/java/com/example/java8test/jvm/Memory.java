package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/28
 */
public class Memory {
    public static void main(String[] args) {
        int i = 1;
        Object obj = new Object();
        Memory memory = new Memory();
        memory.foo(obj);
    }

    private void foo(Object param){
        String str = param.toString();
        System.out.println(str);
    }
}
