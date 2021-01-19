package com.example.java8test.entity;

import java.util.Currency;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/9/1 15:19
 */
public class Transaction {
    /**
     * 主键id
     */
    private String id;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 货币
     */
    private Currency currency;

    public String getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
