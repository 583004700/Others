package scriptManager.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import scriptManager.common.Const;
import scriptManager.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ContextUtil {
    /**
     * 从session中获取用户
     * @return
     */
    public static User getUser(){
        User user = (User)getSession().getAttribute(Const.USER_KEY);
        return user;
    }

    public static HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static String getContextPath(){
        return getRequest().getContextPath();
    }
}
