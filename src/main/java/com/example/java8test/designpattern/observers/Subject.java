package com.example.java8test.designpattern.observers;

/**
 * 主题
 * @author xiangyanlin
 * @date 2021/3/24
 */
public interface Subject {
    /**
     * @param observer
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * @param observer
     * 删除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
