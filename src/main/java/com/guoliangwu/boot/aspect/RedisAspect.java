package com.guoliangwu.boot.aspect;

import com.guoliangwu.boot.exception.BootException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liangwu
 * @Date 18-11-2 上午11:49
 */
@Configuration
@Aspect
@Slf4j
public class RedisAspect {
    @Value("${redis.open: false}")
    private boolean open;

    @Pointcut("execution(* com.guoliangwu.boot.utils.RedisUtils.*(..))")
    public void pointCut(){
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        Object result = null;
        if (open) {
            try {
                result = pj.proceed();
            } catch (Exception e) {
                log.error("redis error", e);
                throw new BootException("redis error");
            }
        }
        return result;
    }
}
