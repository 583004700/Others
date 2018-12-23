package com.byefan.core.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.utils.VerifyUtils;
import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Slf4j
public class SecurityInterceptor implements HandlerInterceptor {

    static final Set<String> NOT_FILTER = new HashSet<>();
    static final Set<String> ADMIN_IPS = new HashSet<>();
    @javax.annotation.Resource
    private Environment env;

    static {
        // 不需要过滤的URL路径
        // NOT_FILTER.add("/");
        NOT_FILTER.add("/login");
        NOT_FILTER.add("/logout");
        NOT_FILTER.add("/code");
        NOT_FILTER.add("/403");
        NOT_FILTER.add("/404");
        NOT_FILTER.add("/500");
        NOT_FILTER.add("/error");
        NOT_FILTER.add("/api/ws/");
        NOT_FILTER.add("swagger-ui.html");
        ADMIN_IPS.add("192.168.2.6");
        ADMIN_IPS.add("192.168.2.104");
        ADMIN_IPS.add("192.168.2.105");
        ADMIN_IPS.add("192.168.2.100");
        ADMIN_IPS.add("192.168.2.101");
        ADMIN_IPS.add("192.168.2.103");
        ADMIN_IPS.add("192.168.2.102");
        ADMIN_IPS.add("192.168.2.130");
        ADMIN_IPS.add("192.168.2.122");
        ADMIN_IPS.add("192.168.2.121");
    }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requested = request.getHeader("x-requested-with");
		String uri = request.getRequestURI();
		if (uri.indexOf("undefined") > 0) {
			return false;
		}
		if (handler instanceof ResourceHttpRequestHandler || NOT_FILTER.contains(uri) || uri.indexOf("/api/ws/") > -1 || uri.indexOf("/process/image") > -1 || uri.indexOf("/expense") > -1 || uri.indexOf("/modeler") > -1) {
			// if (handler instanceof ResourceHttpRequestHandler) {
			return true;
		}
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.getSession();
		if ("/login".equals(uri) && isLogin(request)) {
			// 如果已经登录了，不能再进入登录页面 需要先退出
			response.sendRedirect("/");
			return true;
		}
		if (!isLogin(request)) {// 如果已经登录 直接放行
			// response.sendRedirect("/login");
			redirect(-1, requested, response);
			return false;
		}
		if ("/".equals(uri))
			return true;
		HttpSession session = request.getSession();
		List<Resource> resources = (List<Resource>) session.getAttribute(IConst.USER_RESOURCE);
		String ENVIRONMENT = env.getProperty(IConst.ENVIRONMENT);
		User user = AppUtil.getUser();
		if (("admin".equals(user.getUserName()) && ADMIN_IPS.contains(user.getLoginIp())) || "develop".equals(ENVIRONMENT)) {
			return true;
		}
		// resources = resources == null ? new HashSet<>() : resources;
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			Verify verify = hm.getMethodAnnotation(Verify.class);
			if (verify != null) {
				String code = verify.code();
//				uri = uri.replace("/", "");
				if (!VerifyUtils.isContains(resources, uri) && !VerifyUtils.isContains(resources, code)) {
					// 如果是ajax请求就返回json数据
					redirect(requested, response);
					return false;
				}
			}
		}
		if (handler instanceof ParameterizableViewController) {
			if (!VerifyUtils.isContains(resources, uri)) {
				// 如果是ajax请求就返回json数据
				redirect(requested, response);
				return false;
			}
		}
		return true;
	}

    /**
     * 获取登录信息
     *
     * @param request
     * @return
     */
    public static User getLogin(HttpServletRequest request) {
        // 获取请求头 token
        Object user = request.getSession().getAttribute(IConst.USER_KEY);
        if (user != null) {
            return (User) user;
        }
        // Cookie[] cookies = request.getCookies();
        // if (cookies != null)
        // for (Cookie cookie : cookies) {
        // if (IConst.USER_KEY.equals(cookie.getName())) {
        // String userName = cookie.getValue();
        // User user1 = JSON.parseObject(userName, User.class);
        // return user1;
        // }
        // }
        return null;
    }

    /**
     * 获取登录信息
     *
     * @param request
     * @return
     */
    public static boolean isLogin(HttpServletRequest request) {
        // 获取请求头 token
        Object user = request.getSession().getAttribute(IConst.USER_KEY);
        if (user != null) {
            return true;
        }
        // Cookie[] cookies = request.getCookies();
        // if (cookies != null)
        // for (Cookie cookie : cookies) {
        // if (IConst.USER_KEY.equals(cookie.getName())) {
        // return true;
        // }
        // }

        return false;
    }

    private void redirect(int code, String requested, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        ResponseData responseData = ResponseData.forbidden();
        if (code == -1) {
            if (requested == null) {
                response.sendRedirect("/login");
                return;
            } else {
                responseData = ResponseData.noLogin();
            }
        } else if (code == -2) {
            if (requested == null) {
                response.sendRedirect("/login");
                return;
            } else {
                responseData = ResponseData.customerError(-2, "Token 无效！");
            }
        } else {
            if (requested == null) {
                response.sendRedirect("/403");
                return;
            } else {
                // 如果是ajax请求就返回json数据
                responseData = ResponseData.forbidden();
            }
        }
        responseMessage(out, responseData);
    }

    private void redirect(String requested, HttpServletResponse response) throws IOException {
        // token不存在 ,如果是非ajax请求 就直接跳转到登录页面，如果是ajax请求就返回json数据
        if (requested == null) {
            response.sendRedirect("/403");
        } else {
            // 如果是ajax请求就返回json数据
            PrintWriter out = response.getWriter();
            ResponseData responseData = ResponseData.forbidden();
            responseMessage(out, responseData);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    // 请求不通过，返回错误信息给客户端
    private void responseMessage(PrintWriter out, ResponseData responseData) {
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 继承HttpServletRequestWrapper，创建装饰类，以达到修改HttpServletRequest参数的目的
     */
    private static class ModifyParametersWrapper extends HttpServletRequestWrapper {
        private final Map<String, String> customHeaders;

        ModifyParametersWrapper(HttpServletRequest request) {
            super(request);
            this.customHeaders = new HashMap<>();
        }

        void putHeader(String name, String value) {
            this.customHeaders.put(name, value);
        }

        public String getHeader(String name) {
            // check the custom headers first
            String headerValue = customHeaders.get(name);

            if (headerValue != null) {
                return headerValue;
            }
            // else return from into the original wrapped object
            return ((HttpServletRequest) getRequest()).getHeader(name);
        }

        public Enumeration<String> getHeaderNames() {
            // create a set of the custom header names
            Set<String> set = new HashSet<>(customHeaders.keySet());

			// now add the headers from the wrapped request object
			Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
			while (e.hasMoreElements()) {
				// add the names of the request headers into the list
				String n = e.nextElement();
				set.add(n);
			}

			// create an enumeration from the set and return
			return Collections.enumeration(set);
		}
	}
}
