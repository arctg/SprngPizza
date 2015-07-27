package com.epam.pizza.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 7/23/2015.
 */
public class JavaConfigApplicationContext implements ApplicationContext {

    private Config config;
    private Map<String,Object> beans = new HashMap<>();

    public JavaConfigApplicationContext(Config config){
        this.config = config;
    }

    public Object getBean(String beanName) throws Exception{

        Object bean = beans.get(beanName);
        if (bean !=null){
            return bean;
        }

        BeanBuilder beanBuilder = new BeanBuilder(beanName);
        beanBuilder.createObject();
        beanBuilder.createProxy();
        beanBuilder.callInitMethod();
        return beanBuilder.getObject();

//        Class<?> clazz = config.getImplementation(beanName);
//        Constructor<?> constructor = clazz.getConstructors()[0];
//        Class<?>[] parameter = constructor.getParameterTypes();
//        if (parameter.length == 0){
//            bean = clazz.newInstance();
//            beans.put(beanName,bean);
//            return bean;
//        }
//
//        Object[] args = new Object[parameter.length];
//        String className;
//        String argBeanName;
//        for (int i = 0; i < parameter.length; i++) {
//            className = parameter[i].getSimpleName();
//            argBeanName = className.substring(0, 1).toLowerCase() + className.substring(1);
//            args[i] = getBean(argBeanName);
//        }
//        bean = constructor.newInstance(args);
//        beans.put(beanName,bean);
//        return constructor.newInstance(args);
    }

    class BeanBuilder {

        private Object obj;
        private String beanName;


        BeanBuilder(String beanName) {
            this.beanName = beanName;
        }

        public void createObject() throws Exception{
            Class<?> clazz = config.getImplementation(beanName);
        Constructor<?> constructor = clazz.getConstructors()[0];
        Class<?>[] parameter = constructor.getParameterTypes();
        if (parameter.length == 0){
            obj = clazz.newInstance();
            beans.put(beanName,obj);
            return;
        }

        Object[] args = new Object[parameter.length];
        String className;
        String argBeanName;
        for (int i = 0; i < parameter.length; i++) {
            className = parameter[i].getSimpleName();
            argBeanName = className.substring(0, 1).toLowerCase() + className.substring(1);
            args[i] = getBean(argBeanName);
        }
        obj = constructor.newInstance(args);
        beans.put(beanName,obj);

        }
        public void createProxy(){
            Class<?> clazz = obj.getClass();
            for (Method m:clazz.getMethods()){
                if(m.isAnnotationPresent(Benchmark.class)){
                    obj=createProxyObj(obj);
                }
            }
        }

        private Object createProxyObj(final Object o) {
            final Class<?> type = o.getClass();
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(
                        Object proxy,
                        Method method,
                        Object[] args) throws Throwable {
                    if (type.getMethod(method.getName(),method.getParameterTypes()).isAnnotationPresent(Benchmark.class)) {
                        System.out.println("Behchmark start " + method.getName());
                        long start = System.nanoTime();
                        Object retVal = method.invoke(o, args);
                        long result = System.nanoTime() - start;
                        System.out.println("Benchmark has finished, result is: " + result);
                        return retVal;
                    } else
                        return method.invoke(o,args);
                }
            });
        }
        public void callInitMethod() throws Exception{
            Class<?> clazz = obj.getClass();
            Method method;
            try {
                method = clazz.getMethod("init");
            }catch (NoSuchMethodException e){
                return;
            }
            method.invoke(obj);
        }
        public Object getObject(){
            return obj;
        }
    }
}
