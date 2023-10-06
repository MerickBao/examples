package com.example.learnpigeon.learn;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/23 21:59
 */

public class StaticHelloProxy implements IHello {

    private IHello iHello;

    public void setiHello(IHello iHello) {
        this.iHello = iHello;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("before sayHello");
        iHello.sayHello(name);
    }

    @Override
    public void sayGoodBey(String name) {
        System.out.println("before sayGoodBey");
        iHello.sayGoodBey(name);
    }

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();

        DynamicHelloProxy helloProxy = new DynamicHelloProxy();
        IHello dynamicHello = (IHello) helloProxy.bind(hello);
        dynamicHello.sayHello("11");
    }
}
