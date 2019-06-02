package com.web.api.message.aop;

import java.lang.annotation.*;

/**
 * Created by xingding on 19/6/2.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name() default "";
}
