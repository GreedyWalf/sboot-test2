package com.sboot.test10.aop;


import com.sboot.test10.model.CommonModel;
import com.sboot.test10.model.SendModel;
import com.sboot.test10.service.SendService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Aspect
public class SendAop {

    @Resource
    private SendService sendService;

    /**
     * 为Controller中所有的public属性添加环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(public * com.sboot.test10.controller.*.*(..))")
    public Object doAfterReturning(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("---->>>start doAfterReturning....");
        Object[] args = proceedingJoinPoint.getArgs();
        Object arg = args[0];

        if(arg instanceof CommonModel){
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println(proceed);
            return "is true";
        }else{
            return "is false";
        }
    }

}
