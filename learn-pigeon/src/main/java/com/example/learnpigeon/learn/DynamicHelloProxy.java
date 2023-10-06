package com.example.learnpigeon.learn;

import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/23 22:04
 */
@Slf4j
public class DynamicHelloProxy implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println("before say something");
            if (method.getName().equals("sayHello")) {
                System.out.println("before sayHello");
            } else if (method.getName().equals("sayGoodBey")) {
                System.out.println("before sayGoodBey");
            }
            // JVM通过这条语句执行原先的方法
            result = method.invoke(this.delegate, args);
        } catch (Exception e) {
            log.error("error", e);
        }
        return result;
    }
}
