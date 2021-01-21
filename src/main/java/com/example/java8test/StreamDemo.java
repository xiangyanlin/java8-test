package com.example.java8test;

import com.example.java8test.entity.Person;
import com.google.common.base.CaseFormat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/9/11 10:33
 */
public class StreamDemo {
    public static void main(String[] args) {
//        testStream1();
        //testStream2();
        //testFunction();


    }

    private static void testFunction() {
        Function<String, Integer> function=s -> s.length();
        System.out.println(function.apply("qwe"));

        Predicate<String> predicate=s -> s.isEmpty();
        System.out.println(predicate.test("qaz"));

        Consumer<String> consumer=s -> System.out.println(s);
        consumer.accept("xiangyanlin");

        Supplier<String> supplier=()-> "hahaha";
        System.out.println(supplier.get());
    }


    private static void testStream2() {
        Person person1=new Person(11,"a",23);
        Person person2=new Person(12,"b",24);
        Person person3=new Person(13,"d",22);
        Person person4=new Person(14,"c",28);
        Person person5=new Person(15,"e",26);
        //System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, person1.getName()));
        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);
        //偶数ID，年龄大于24，用户名转为大写，用户名字母倒序MAMS_WX_MP_TEMPLATE
        personList.stream()
                .filter(person->person.getId()%2==0&&person.getAge()>24)
               .sorted(Comparator.comparing(Person::getName))
                .map(person->{
                    String name = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, person.getName());
                    person.setName(name);
                    return person;
                })
                .forEach(System.out::println);
    }

    private static void testStream1(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        numbers.stream().map( i -> i*i).distinct().forEach(System.out::println);
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
        strings.stream().limit(3).forEach(System.out::println);
    }
}
