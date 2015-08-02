package com.epam.pizza.infrastructure;

/**
 * Created by dennis on 7/23/2015.
 */
public class ObjectFactory {

    private static ObjectFactory instance;
    private Config config = new JavaConfig();

    private ObjectFactory(){
    }

    public static ObjectFactory getInstance() {
        if(instance!=null){
            return instance;
        }
        instance = new ObjectFactory();
        return instance;
    }

    public Object createObject(String someString) throws Exception{
        Class<?> clazz = config.getImplementation(someString);
        return clazz.newInstance();
    }
}
