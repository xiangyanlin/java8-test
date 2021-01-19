package com.example;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/9/11 10:33
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
/*        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);*/
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

//        numbers.stream().map( i -> i*i).distinct().forEach(System.out::println);
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
       // System.out.println(count);
        strings.stream().limit(3).forEach(System.out::println);
    }
}
