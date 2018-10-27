package com.ry.xk;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ry.xk.main.bo.User;
import com.ry.xk.main.service.IUserService;
import com.ry.xk.utils.JwtHelper;

/**
 * 定义Token过滤器
 * 
 * @ClassName: TokenInterceptor
 * @author 幸仁强
 * @date 2018年5月26日
 */

public class TokenInterceptor implements HandlerInterceptor
{

    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();

        // 如果请求不来源于我们的controller，则直接返回true
        if (handlerMethod.getBeanType().getName().indexOf("com.ry.xk") < 0 || handlerMethod.getBeanType().getName().indexOf(".controller.") < 0)
        {
            return true;
        }
        // 获取出方法上的IgnoreToken注解
        IgnoreToken ignoreToken = method.getAnnotation(IgnoreToken.class);
        // 如果方法头上有注解，并且注解的value为true则直接返回true，表示不用校验授权
        if ((null != ignoreToken && ignoreToken.value() == true))
        {
            return true;
        }
        else
        {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            Cookie[] cookie = httpRequest.getCookies();
            if (null != cookie)
            {
                Cookie cook = Arrays.asList(cookie).stream().filter(switchEnum -> switchEnum.getName().equals("authorization")).findFirst().orElse(null);
                if (null != cook && StringUtils.isNotBlank(cook.getValue()) && null != JwtHelper.parseJWT(cook.getValue()))
                {
                    int userId = JwtHelper.getUserId(cook.getValue());
                    User user = userService.get(userId);
                    if (null != user && user.getUserId() > 0)
                    {
                        return true;
                    }
                }
            }
        }

        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper mapper = new ObjectMapper();
        httpResponse.getWriter().write(mapper.writeValueAsString("Invalid token"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception
    {
        // System.out.println("postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception
    {
        // System.out.println("afterCompletion");
    }
}
