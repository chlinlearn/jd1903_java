package com.briup.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明一个annotation
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {

}
