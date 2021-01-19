package com.example.java8test;
import com.example.java8test.entity.Apple;
import org.junit.Test;
/**
 * @Author XiangYanLin.
 * @Date Created in 18:09 2020/11/19
 * @Description：
 */
public class ValueDemo {
    @Test
    public void testValue(){
        Apple apple=null;

        Object test=new Object();
        NewApple(apple);
        System.out.println(apple);
    }

    private void NewApple(Apple apple){
        apple=new Apple();
        apple.setId("123");
    }
}
