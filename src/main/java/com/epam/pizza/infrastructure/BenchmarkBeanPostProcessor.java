package com.epam.pizza.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dennis on 8/2/2015.
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

//    @Override
//    public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException {
//        return new ProxyForBenchmarkAnnotation().checkAndCreateProxyObjForBenchmark(bean);
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }

    @Override

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        Class type = bean.getClass();
        if (type.isAnnotationPresent(Benchmark.class)) {
            Object proxy = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long before = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println("method has worked: " + (after - before) + " nanoseconds");
                    return retVal;
                }
            });
            return proxy;
        } else {
            return bean;
        }
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        return bean;
    }

}

