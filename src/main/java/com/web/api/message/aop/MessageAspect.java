package com.web.api.message.aop;

import com.web.api.message.entity.Message;
import com.web.api.message.service.MessageService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xingding on 19/6/2.
 */
@Aspect
@Component
public class MessageAspect {

    @Autowired
    MessageService messageService;


    @Pointcut("@annotation(com.web.api.message.aop.Action)")
    public void annotationPointCut(){}

    @AfterReturning("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        Map<String, Object> params = getParams(signature, joinPoint);
        if("comment".equals(action.name())){
            String who = (String)params.get("who");
            System.out.println("who: " + who);

            Message message = new Message();
            message.setId(UUID.randomUUID().toString().replaceAll("-",""));
            message.setTitle("test case");
            message.setContent(who + "comments your task");
            message.setType(1);
            message.setCreatedName("kang");
            message.setCreatedTime(new Date());

            messageService.save(message);


        } else{
            System.out.println("nothing to do!");
        }

    }

    private Map<String, Object> getParams(MethodSignature signature, JoinPoint joinPoint) {
        Map<String, Object> map = new HashMap<>();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            map.put(parameterNames[i], args[i]);
        }
        return map;
    }
}
