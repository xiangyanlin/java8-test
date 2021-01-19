package com.example.java8test;

import com.example.java8test.entity.Apple;
import com.example.java8test.entity.Transaction;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/8/21 10:02
 */
public class TestDemo {
//    public static void main(String[] args) {
//        List<Apple> inventory = new ArrayList<Apple>();
//        Apple apple1 = new Apple();
//        apple1.setId("1");
//        apple1.setColor("red");
//        apple1.setWeight(200);
//        inventory.add(apple1);
//
//        Apple apple2 = new Apple();
//        apple2.setId("2");
//        apple2.setColor("green");
//        apple2.setWeight(100);
//        inventory.add(apple2);
//
//        Apple apple3 = new Apple();
//        apple3.setId("3");
//        apple3.setColor("green");
//        apple3.setWeight(50);
//        inventory.add(apple3);
//
////        List<Apple> apples = filterGreenApples(inventory);
////        List<Apple> apples2 = filterHeavyApples(inventory);
//        // System.out.println(apples2);
//
////        List<Apple> apples1 = filterApples(inventory, Apple::isGreenApple);
////        System.out.println(apples1);
////        List<Apple> apples3 = filterApples(inventory, Apple::isHeavyApple);
////        System.out.println(apples3);
////        List<Apple> apples = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
////
////        List<Apple> apples1 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
////
////        final List<Apple> apples2 = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
////        System.out.println("第一个过滤结果：" + apples);
////        System.out.println("第二个过滤结果：" + apples1);
////        System.out.println("第三个过滤结果：" + apples2);
//
////        List<Apple> heavyApples =
////                inventory.stream().filter((Apple a) -> a.getWeight() > 150)
////                        .collect(toList());
////        System.out.println("第三个过滤结果：" + heavyApples);
//        List<Apple> heavyApples =
//                inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150)
//                        .collect(toList());
//        System.out.println("过滤结果：" + heavyApples);
//    }
//
//
//    public interface Predicate<T> {
//        boolean test(T t);
//    }
//
//    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (p.test(apple)) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
//
//
//    public static List<Apple> filterGreenApples(List<Apple> inventory) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if ("green".equals(apple.getColor())) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
//
//    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getWeight() > 150) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
//
//
//    public static void testMap(List<Transaction> transactions){
//        Map<Currency, List<Transaction>> transactionsByCurrencies =new HashMap<>();
//
//        for(Transaction transaction :transactions){
//            if (transaction.getPrice() > 1000) {
//                Currency currency = transaction.getCurrency();
//                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
//                if (transactionsForCurrency == null) {
//                    transactionsForCurrency = new ArrayList<>();
//                    transactionsByCurrencies.put(currency,
//                            transactionsForCurrency);
//                }
//                transactionsForCurrency.add(transaction);
//            }
//        }
//        Map<Currency, List<Transaction>> transactionsBy = transactions.stream()
//                .filter((Transaction t) -> t.getPrice() > 1000)
//                .collect(groupingBy(Transaction::getCurrency));
//    }

    public static void main(String[] args) {
        Apple apple = null;

        test(apple);
        System.out.println(apple);
    }

    private static void test(Apple apple) {
        apple=new Apple();
        apple.setId("123");
    }
}




