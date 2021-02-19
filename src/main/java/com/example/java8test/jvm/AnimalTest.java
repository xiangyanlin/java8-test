package com.example.java8test.jvm;

/**
 * @author XiangYanLin
 * @date 2021/2/19
 * 方法调用
 */
class Animal{
    public void eat(){
        System.out.println("动物进食！~");
    }
}

interface Huntable{
    void hunt();
}

class Dog extends Animal implements Huntable{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("狗拿耗子 ，多管闲事");

    }
}

class Cat extends Animal implements Huntable{

    //早期绑定
    public Cat(){
        super();
    }

    public Cat(String name){
        this();
    }

    @Override
    public void eat() {
        System.out.println("狗吃鱼");
    }

    @Override
    public void hunt() {
        System.out.println("猫捉耗子 ，天经地义");

    }
}
public class AnimalTest {
    public void showAnimal(Animal animal){
        //表现为晚期绑定
        animal.eat();
    }
    public void showHunt(Huntable huntable){
        //表现为晚期绑定
        huntable.hunt();
    }
}
