package com.example.java8test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author XiangYanLin
 * @date 2021/1/21
 * 异步回调
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"没有返回值， update mysql ok");
        });

        CompletableFuture<Integer> completableFuture2=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"没有返回值， update mysql ok");
            int a=10/0;
            return 1024;
        });

        System.out.println(completableFuture2.whenComplete((t,u)->{
            System.out.println("******* t:"+t);
            System.out.println("******* u:"+u);
        }).exceptionally(f->{
            System.out.println("******* exception"+f.getMessage());
            return 4444;
        }).get());
    }
}
