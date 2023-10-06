package com.example.learnpigeon.learn;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/23 21:58
 */

public class HelloImpl implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    @Override
    public void sayGoodBey(String name) {
        System.out.println("good bey " + name);
    }
}
