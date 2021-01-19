package com.example.java8test.entity;

import java.io.Serializable;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/8/21 10:07
 */
public class Apple implements Serializable {

    private static final long serialVersionUID = -1315053955059469208L;
    /**
     * 主键id
     */
    private String id;

    /**
     * 颜色
     */
    private String color;

    private transient Integer weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

//    public static boolean isGreenApple(Apple apple) {
//        return "green".equals(apple.getColor());
//    }
//
//    public static boolean isHeavyApple(Apple apple) {
//        return apple.getWeight() > 150;
//    }
}
