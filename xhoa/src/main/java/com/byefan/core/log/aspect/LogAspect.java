package com.byefan.core.log.aspect;

import com.byefan.core.interceptor.SecurityInterceptor;
import com.byefan.core.log.annotation.Log;
import com.byefan.core.serivce.ILogService;
import com.byefan.core.utils.IpUtils;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.utils.AppUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.flowable.spring.boot.app.App;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    @Autowired
    ILogService logService;

    //    @Pointcut("execution(* com.byefan.xhoa.controller.*.*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    @Pointcut("execution(* com.byefan.*.controller.*.*.*(..)) and @annotation(com.byefan.core.log.annotation.Log)")
    public void executeLog() {
    }

    /**
     * 拦截器具体实现
     *
     * @param joinPoint
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Before("executeLog()")
    public void before(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
//        try {
//            MethodInvocationProceedingJoinPoint methodPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
//            Field proxy = methodPoint.getClass().getDeclaredField("methodInvocation");
//            proxy.setAccessible(true);
//            ReflectiveMethodInvocation j = (ReflectiveMethodInvocation) proxy.get(methodPoint);
//            Method method = j.getMethod();
//            Log la = method.getAnnotation(Log.class);
//            if (la != null) {
//                info = new StringBuilder();
//                log = new com.byefan.wss.entity.Log();
//                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//                HttpServletRequest request = attributes.getRequest();
//                User user = SecurityInterceptor.getLogin(request);
//                //url
//                String url = request.getRequestURI();
//                info.append(",url ={").append(url).append("},");
//                //method
//                info.append("method={").append(request.getMethod()).append("},");
//                //ip
//                String ip = request.getRemoteAddr();
//                info.append("ip={").append(ip).append("},");
//                //类方法
//                Signature signature = joinPoint.getSignature();
//                String className = signature.getDeclaringTypeName();
//                String methodName = signature.getName();
////                info.append("class_method={}", className + '.' + methodName);//获取类名及类方法
//                info.append("class_method={").append(className).append('.').append(methodName).append("},");
//                //参数
//                Object[] args = joinPoint.getArgs();
//                StringBuilder params = new StringBuilder();
//                if (args != null)
//                    for (Object arg : args) {
//                        params.append(arg != null ? arg.toString() : "").append(",");
//                    }
//                info.append("args={").append(args).append("},");
//                log.setOpType(la.opType().getName());
//                log.setNote(la.note());
//                log.setModule(la.module());
//                log.setClassName(className);
//                log.setMethodName(methodName);
//                log.setArgs(params.toString());
//                log.setOpDate(new Date());
//                log.setIp(ip);
//                log.setUrl(url);
//                if (user != null)
//                    log.setUser(user);
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
    }

    // result of return
    @AfterReturning(pointcut = "executeLog()", returning = "retVal")
    public void after(JoinPoint joinPoint, Object retVal) {
//        startTime.set(System.currentTimeMillis());
        try {
            MethodInvocationProceedingJoinPoint methodPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
            Field proxy = methodPoint.getClass().getDeclaredField("methodInvocation");
            proxy.setAccessible(true);
            ReflectiveMethodInvocation j = (ReflectiveMethodInvocation) proxy.get(methodPoint);
            Method method = j.getMethod();
            Log la = method.getAnnotation(Log.class);
            if (la != null) {
                StringBuilder info = new StringBuilder();
                com.byefan.core.entity.Log log = new com.byefan.core.entity.Log();
//                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//                HttpServletRequest request = attributes.getRequest();
//                User user = SecurityInterceptor.getLogin(request);
                HttpServletRequest request = AppUtil.getRequest();
                User user = AppUtil.getUser();
                //url
                String url = request.getRequestURI();
                info.append(",url ={").append(url).append("},");
                //method
                info.append("method={").append(request.getMethod()).append("},");
                //ip
                String ip = IpUtils.getIpAddress(request);//request.getRemoteAddr();

                info.append("ip={").append(ip).append("},");
                //类方法
                Signature signature = joinPoint.getSignature();
                String className = signature.getDeclaringTypeName();
                String methodName = signature.getName();
//                info.append("class_method={}", className + '.' + methodName);//获取类名及类方法
                info.append("class_method={").append(className).append('.').append(methodName).append("},");
                //参数
                Object[] args = joinPoint.getArgs();
                StringBuilder params = new StringBuilder();
                if (args != null)
                    for (Object arg : args) {
                        params.append(arg != null ? arg.toString() : "").append(",");
                    }
                info.append("args={").append(args).append("},");
                log.setOpType(la.opType().getName());
                log.setNote(la.note());
                log.setModule(la.module());
                log.setClassName(className);
                log.setMethodName(methodName);
                log.setArgs(params.toString());
                log.setOpDate(new Date());
                log.setIp(ip);
                log.setUrl(url);
                if (user != null)
                    log.setUser(user);
                info.append("response={").append(retVal == null ? "" : retVal.toString()).append("}");
                log.setNote(log.getNote() + info.toString());
                logService.save(log);
                log = null;
                info = null;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.gc();
        }
    }

    @After("executeLog()")//无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter() {
    }
}