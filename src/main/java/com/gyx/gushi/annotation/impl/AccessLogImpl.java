package com.gyx.gushi.annotation.impl;

import com.gyx.gushi.annotation.AccessLog;
import com.gyx.gushi.pojo.Access;
import com.gyx.gushi.service.AccessService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 郭一行
 * @date 2019-02-20 09:14
 * @since 1.0.0
 */
@Aspect
@Component
public class AccessLogImpl {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AccessService accessService;

    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    /**
     * 对指定注解，进行横切，创建一个横切的对象方法
     */
    @Pointcut("@annotation(com.gyx.gushi.annotation.AccessLog)")
    public void annotationPoint() {
    };

    @Before("annotationPoint()")
    public void beforeMethod(JoinPoint joinpoint) {
        AccessLog accessLog = ((MethodSignature) joinpoint.getSignature())
                .getMethod().getAnnotation(AccessLog.class);
        String ipAddress = getIpAddress(request);
        Access access = new Access(ipAddress,new Date(),accessLog.value());
        accessService.add(access);
    }
}
