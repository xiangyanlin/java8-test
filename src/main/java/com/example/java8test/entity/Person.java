package com.example.java8test.entity;

/**
 * @Author XiangYanLin.
 * @Date Created in 16:25 2020/12/4
 * @Description：
 * person对象没有实现Comparable接口，所以必须实现，这样才不会出错，才可以使treemap中的数据按顺序排列
 *
 */
public  class Person implements Comparable<Person> {
    private int id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person( int id,String name, int age) {
        super();
        this.id=id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * T重写compareTo方法实现按年龄来排序
     */
//    @Override
//    public int compareTo(Person o) {
//        if (this.age > o.getAge()) {
//            return 1;
//        }
//        if (this.age < o.getAge()) {
//            return -1;
//        }
//        return 0;
//    }
    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}
