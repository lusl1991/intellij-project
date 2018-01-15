package com.softel.advice;

import com.softel.model.utils.Response;
import com.softel.model.utils.ResultVo;
import com.softel.service.exception.ServiceException;
import com.softel.model.utils.ExceptionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.ValidationException;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 10:44 2018/1/15
 * @modified By:
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     * @return 异常提示
     */
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        //不需要再记录ServiceException，因为在service异常切面中已经记录过
        if (!(e instanceof ServiceException)) {
            LOGGER.error(ExceptionUtils.getExcTrace(e));
        }

        String message = StringUtils.isEmpty(e.getMessage()) ? "系统异常!!" : e.getMessage();
        return new Response().failure(message);
    }

}
