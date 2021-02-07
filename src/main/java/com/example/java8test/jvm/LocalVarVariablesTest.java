package com.example.java8test.jvm;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XiangYanLin
 * @date 2021/2/5
 */
public class LocalVarVariablesTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer();
        Lock lock=new ReentrantLock(true);
        stringBuffer.append("11");
        LocalVarVariablesTest test=new LocalVarVariablesTest();
        int n=10;
    }

    public static void test() {
        Date date=new Date();
        int n=10;
        LocalVarVariablesTest stackErrorTest=new LocalVarVariablesTest();
        System.out.println("111");

    }

    public  void test1() {
        Date date=new Date();
        int n=10;
        StackErrorTest stackErrorTest=new StackErrorTest();
        System.out.println("111");

    }

    public void test2(){
        int a=0;
        {
            int b=0;
            b=a+1;
        }
        //变量c使用b已销毁的slot
        int c=a+1;
    }
}
