package org.hua.tiktok.authority;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hua.tiktok.exception.AuthorityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AuthorityAOP {

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(authority)")
    public Object  authority(ProceedingJoinPoint joinPoint, Authority authority) throws Throwable{
        Boolean result;
        Method method;
        Object verifyObject;

        if(!AuthorityUtils.getPostAuthority()){
            //全局校验类
            Class globalVerify = AuthorityUtils.getGlobalVerify();
            verifyObject = globalVerify.newInstance();
            method = globalVerify.getMethod("authorityVerify", HttpServletRequest.class,String[].class);
            result = (Boolean) method.invoke(verifyObject,request,authority.value());
            if(!result) throw new AuthorityException("权限不足");
        }
        return joinPoint.proceed();
    }


}
