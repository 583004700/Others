package com.byefan.core.utils;

import com.byefan.xhoa.entity.sys.Resource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 判断是否有权限访问
 *
 * @author GZW
 */
public class VerifyUtils {
    /**
     * 判断权限是否存在
     */
    static AntPathMatcher antPathMatcher = new AntPathMatcher();

    public static boolean isContains(Collection<Resource> resources, String code) {
        boolean flag = false;
        if (resources != null)
            for (Resource resource : resources) {
                List<Resource> childs = resource.getChilds();
                String url = resource.getUrl();
//                if (StringUtils.isEmpty(url))
//                    return true;
                if (childs == null || childs.size() == 0) {
                    if (url.indexOf("/") > 0) url = "/" + url;
                    if (resource.getState() == 0 && antPathMatcher.match(url.trim(), code.trim())) {// 有权访问该资源
                        return true;
                    }
                } else {
                    flag = isContains(childs, code);
                    if (flag == true) return true;
                }
            }
        return flag;
    }

    public boolean urlIsContains(Collection<String> urls, String code) {
        if (urls != null)
            for (String url : urls) {
                if (antPathMatcher.match(url.trim(), code.trim())) {// 有权访问该资源
                    return true;
                }
            }
        return false;
    }
}
