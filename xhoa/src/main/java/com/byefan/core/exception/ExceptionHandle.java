package com.byefan.core.exception;

import com.byefan.core.ResponseData;
import com.byefan.xhoa.utils.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData handle(Exception e) {
        if (e instanceof ByeFanException) {
            ByeFanException e1 = (ByeFanException) e;
            return ResponseData.customerError(e1.getCode(), e1.getMessage());
        } else {
            log.error("【系统异常】{}", e);
            return ResponseData.customerError(-1, e.getMessage());
        }
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ByeFanException.class)
    public ResponseData myErrorHandler(ByeFanException ex) {
        HttpServletRequest request = AppUtil.getRequest();
        HttpServletResponse response = AppUtil.getResponse();
        String requested = request.getHeader("x-requested-with");
        if (requested == null) {
            try {
                response.sendRedirect("/403");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseData.customerError(ex.getCode(), ex.getMessage());
    }

}