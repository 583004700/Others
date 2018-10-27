package com.ry.xk;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.main.bo.User;
import com.ry.xk.main.service.UserService;
import com.ry.xk.utils.HttpHelper;

/**
 * 拦截request对象，并填充公共属性拦截器 <描述类的作用>
 * 
 * @ClassName: RequestBaseFilter
 * @author 幸仁强
 * @date 2018年5月28日
 */
@Component
// @ServletComponentScan
// @WebFilter(urlPatterns = "/*")
public class RequestBaseFilter implements Filter
{

    public void destroy()
    {

    }

    @Autowired
    private UserService userService;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException,
        ServletException
    {
        HttpServletResponse response = (HttpServletResponse)res;
        HttpServletRequest reqs = (HttpServletRequest)req;
        try
        {
            /**
             * response.setHeader("Access-Control-Allow-Origin", reqs.getHeader("Origin"));
             * response.setHeader("Access-Control-Allow-Credentials", "true");
             * response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
             * response.setHeader("Access-Control-Max-Age", "3600");
             * response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
             * response.setCharacterEncoding("UTF-8"); response.setContentType("application/json;
             * charset=utf-8");
             **/
            ServletRequest requestWrapper = null;
            String method = reqs.getMethod();
            if ("POST".equalsIgnoreCase(method))
            {
                requestWrapper = new BodyReaderHttpServletRequestWrapper(reqs); // 替换
                if(!reqs.getRequestURL().toString().contains("order/payNotify")&&!reqs.getRequestURL().toString().contains("order/checkPayResult"))
                {
                String body = HttpHelper.getBodyString(requestWrapper);
                ResponseBase<Object> responseBase = checkPartnerId(body);
                if (null != responseBase)
                {
                    response.getWriter().write(JSONObject.toJSONString(responseBase));
                    response.getWriter().close();
                    return;
                }
                }
                chain.doFilter(requestWrapper, response);
            }
            else
            {
                chain.doFilter(reqs, response);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            chain.doFilter(reqs, response);
        }
    }

    private ResponseBase<Object> checkPartnerId(String body)
    {
        ResponseBase<Object> responseBase = new ResponseBase<Object>();

        Map<String, Object> map = JSON.parseObject(body);
        System.out.println();
        if (!map.containsKey("orgId") || null == map.get("orgId") || map.get("orgId").toString().isEmpty())
        {
            responseBase.setMessage("机构ID不能为空");
            responseBase.setResultType(CommonConst.RT_FAIL);
            return responseBase;
        }
        int partnerId = Integer.parseInt(map.get("partnerId").toString());
        if (Integer.parseInt(map.get("partnerId").toString()) == 0)
        {
            responseBase.setMessage("机构ID错误");
            responseBase.setResultType(CommonConst.RT_FAIL);
            return responseBase;
        }
        if (map.containsKey("userId") && StringUtils.isNotBlank(map.get("userId").toString()))
        {
            try
            {
                int userId = Integer.parseInt(map.get("userId").toString());
                User user = userService.get(userId);
                if (!(user.getPartnerId() == partnerId))
                {
                    throw new Exception();
                }
            }
            catch (Exception e)
            {
                responseBase.setMessage("用户和机构不匹配");
                responseBase.setResultType(CommonConst.RT_FAIL);
                return responseBase;
            }
        }

        return null;
    }

    public void init(FilterConfig fConfig)
        throws ServletException
    {}

}
