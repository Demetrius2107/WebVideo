package org.hua.tiktok.limit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.hua.tiktok.constant.RedisConstant;
import org.hua.tiktok.exception.LimiterException;
import org.hua.tiktok.holder.UserHolder;
import org.hua.tiktok.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

@Aspect
public class LimitAop {

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    public Object restriction(ProceedingJoinPoint joinPoint,Limit limiter) throws Throwable {
        final long userId = UserHolder.get();
        final int limitCount = limiter.limit();
        final String msg = limiter.msg();
        final long time = limiter.time();
        //缓存是否存在
        String key = RedisConstant.VIDEO_LIMIT + userId;
        final Object o1 = redisCacheUtil.get(key);
        if(ObjectUtils.isEmpty(o1)){
            redisCacheUtil.set(key,1,time);
        }else {
            if(Integer.parseInt(o1.toString()) > limitCount){
                throw new LimiterException(msg);
            }
            redisCacheUtil.incr(key,1);
        }
        Object o = joinPoint.proceed();
        return o;
    }
}
