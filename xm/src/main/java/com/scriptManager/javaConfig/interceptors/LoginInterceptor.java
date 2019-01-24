package com.scriptManager.javaConfig.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.scriptManager.common.Const;
import com.scriptManager.entity.User;
import com.common.util.ContextUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    //直接放行的uri
    private static Map<String,String> ignoreUri = new HashMap<String,String>();
    static{
        ignoreUri.put(Const.LOGIN_PAGE, Const.LOGIN_PAGE);
        ignoreUri.put("/user/loginAction","/user/loginAction");
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        User user = ContextUtil.getUser();
        if(user == null && !ignoreUri.containsKey(uri)){
            httpServletResponse.sendRedirect(ContextUtil.getContextPath()+Const.LOGIN_PAGE);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
