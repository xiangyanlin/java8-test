package com.example.java8test.designpattern.observers;

/**
 * @author xiangyanlin
 * @date 2021/3/24
 */
public class ConcreteSubject implements Subject{


    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
