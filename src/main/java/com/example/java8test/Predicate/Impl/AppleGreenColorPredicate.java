package com.example.java8test.Predicate.Impl;

import com.example.java8test.entity.Apple;
import com.example.java8test.Predicate.ApplePredicate;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/9/10 9:39
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }
}
