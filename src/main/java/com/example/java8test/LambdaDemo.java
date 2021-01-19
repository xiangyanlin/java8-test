package com.example.java8test;

import com.example.java8test.entity.Apple;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/9/10 9:25
 */
public class LambdaDemo {

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setId("1");
        apple1.setColor("red");
        apple1.setWeight(200);


        Apple apple2 = new Apple();
        apple2.setId("2");
        apple2.setColor("green");
        apple2.setWeight(100);


        Apple apple3 = new Apple();
        apple3.setId("3");
        apple3.setColor("green");
        apple3.setWeight(50);

        List<Apple> inventory = Arrays.asList(apple1,
                apple2,
                apple3);
        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        System.out.println(byWeight.compare(apple2,apple1));

        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);

    }
    public interface Converter<T1, T2> {
        void convert(int i);
    }


}
