package com.byefan.xhoa.utils;

import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 应用程序工具类
 */
public class AppUtil {
    /**
     * 获取request
     *
     * @return HttpServletResponse
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取 response
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static User getUser() {
        Object obj = getSession().getAttribute(IConst.USER_KEY);
        if (obj != null) {
            User user = (User) obj;
            return user;
        } else {
            return null;
        }
    }

    /**
     * 获取key获取信息
     *
     * @return
     */
    public static <T> T get(String key) {
        Object obj = getSession().getAttribute(key);
        if (obj != null) {
            T t = (T) obj;
            return t;
        } else {
            return null;
        }
    }

    /**
     * 判断是否是某个岗位
     *
     * @return
     */
    public static boolean isRoleCode(String code) {
        User user = AppUtil.getUser();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (code.equalsIgnoreCase(role.getCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是某个角色
     *
     * @return
     */
    public static boolean isRoleType(String type) {
        User user = AppUtil.getUser();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (type.equalsIgnoreCase(role.getType())) {
                return true;
            }
        }
        return false;
    }
}
