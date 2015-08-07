package com.epam.pizza.infrastructure.impl;

import com.epam.pizza.infrastructure.Benchmark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


//    private Class<?>[] getInterfaces(Class<?> type) {
//
//        List<Class<?>> allInterfaces = new ArrayList<>();
//        Class<?>[] interfaces = type.getInterfaces();
//        allInterfaces.addAll(Arrays.asList(interfaces));
//
//        Class<?> superClass = type.getSuperclass();
//        if (superClass != null) {
//            allInterfaces.addAll(Arrays.asList(getInterfaces(superClass)));
//        }
//
//        Class<?>[] result = new Class<?>[allInterfaces.size()];
//        for (int i = 0; i < allInterfaces.size(); ++i) {
//            result[i] = allInterfaces.get(i);
//        }
//
//        return result;
//    }
}