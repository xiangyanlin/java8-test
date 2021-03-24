package com.example.java8test.designpattern.observers;

/**
 * 气象站
 * @author xiangyanlin
 * @date 2021/3/24
 */
public interface Observer {
    /**
     * @param temp
     * @param humidity
     * @param pressure
     * 气象站更新方法
     */
    void update(float temp, float humidity, float pressure );
}
