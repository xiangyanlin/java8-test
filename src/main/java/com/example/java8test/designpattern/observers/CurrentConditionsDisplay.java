package com.example.java8test.designpattern.observers;

/**
 * @author xiangyanlin
 * @date 2021/3/24
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement  {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure=pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: temperature=" + temperature
                + "F degrees and " + humidity + "% humidity"+" and pressure="+pressure);
    }

}
