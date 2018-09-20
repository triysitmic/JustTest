package com.zyd.justtest.change;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by zhengyanda on 2018/6/19.
 */
public class TypeChangeTest implements Runnable{

    private static int i=0;

    private synchronized void increase(){
        i ++;
    }

    @Override
    public void run() {
        for (int j = 0 ; j < 10000; j ++){
            increase();
        }
    }

    @Test
    public void test() throws InterruptedException {
        TypeChangeTest instance = new TypeChangeTest();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}