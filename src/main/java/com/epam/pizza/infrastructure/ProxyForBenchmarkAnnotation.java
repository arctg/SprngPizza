package com.epam.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dennis on 7/27/2015.
 */
public class ProxyForBenchmarkAnnotation {


    Object checkAndCreateProxyObjForBenchmark(Object object) throws IllegalArgumentException {
        Class<?> clazz = object.getClass();
        for (Method m : clazz.getMethods()) {
            if (m.isAnnotationPresent(Benchmark.class)) {
                return createProxyObj(object);
            }
        }
        return object;
    }

    private Object createProxyObj(final Object o) {
        final Class<?> type = o.getClass();
        return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(
                    Object proxy,
                    Method method,
                    Object[] args) throws Throwable {
                if (type.getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Benchmark.class)) {
                    System.out.println("Behchmark starts " + method.getName());
                    long start = System.nanoTime();
                    Object retVal = method.invoke(o, args);
                    long result = System.nanoTime() - start;
                    System.out.println("Benchmark has finished, result is: " + result);
                    return retVal;
                } else
                    return method.invoke(o, args);
            }
        });
    }
}