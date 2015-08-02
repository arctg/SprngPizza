package com.epam.pizza.infrastructure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dennis on 7/27/2015.
 */
@Target(ElementType.METHOD) // for which can be applied - for method.
@Retention(RetentionPolicy.RUNTIME)
public @interface Benchmark {

}
