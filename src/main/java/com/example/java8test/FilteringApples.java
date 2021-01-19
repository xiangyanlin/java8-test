package com.example.java8test;

import com.example.java8test.Predicate.Impl.AppleGreenColorPredicate;
import com.example.java8test.Predicate.Impl.AppleHeavyWeightPredicate;
import com.example.java8test.entity.Apple;
import com.example.java8test.Predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/9/10 9:40
 */
public class FilteringApples{
    public static void main(String...args){
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
        List<Apple> heavyApples =
                filterApples(inventory, new AppleHeavyWeightPredicate());
        System.out.println(heavyApples);
        List<Apple> greenApples =
                filterApples(inventory, new AppleGreenColorPredicate());
        System.out.println(greenApples);
    }
    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}

