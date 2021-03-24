package com.example.java8test;

import com.example.java8test.entity.Person;

import java.util.Optional;


/**
 * @author xiangyanlin
 * @date 2021/3/23
 */

public class OptionalTest {
    public static void main(String[] args) {
        /**
         * 用法1取代空判断
         */
        String str = "123";
        Person person = null;
        System.out.println("1111111");
        Optional.ofNullable(person).ifPresent(o -> System.out.println(o));
        person = new Person().setId(123).setName("haha").setAge(18);
        System.out.println("2222222");
        Optional.ofNullable(person).ifPresent(o -> System.out.println(o));

        /**
         * 用法2
         */
        String s = Optional.ofNullable(person)
                .filter(e -> e.getId().equals(123))
                .map(e -> e.getName()).orElse(null);
        System.out.println(s);


        /**
         * 用法三
         */
        Optional<String> optional = Optional.ofNullable(person)
                .flatMap(e -> Optional.of(e.getName()));
        System.out.println(optional.get());
    }
}

