package com.byefan.core.controller;


import com.byefan.core.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Gzw
 */
@Controller
@RequestMapping("code")
public class CodeController {
//
//    @Autowired
//    DefaultKaptcha defaultKaptcha;

    @GetMapping("/image")
    public void getImage(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.getCode(4);
        //存入会话session
        request.getSession().setAttribute("verifyCode", verifyCode.toLowerCase());
        //生成图片
        int w = 200, h = 60;
        VerifyCodeUtils.outImage(w, h, response.getOutputStream(), verifyCode);
    }
}
