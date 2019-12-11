package com.cimc.handle;

import com.cimc.entity.Result;
import com.cimc.exception.ArticleException;
import com.cimc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获处理
 */

@ControllerAdvice
public class ExceptionHandle {

    // 处理类异常
    private final  static Logger logger =  LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof ArticleException){
            ArticleException a=(ArticleException)e;
            return ResultUtil.ERROR(a.getCode(),a.getMessage());
        }else {
            // 向后台抛出异常，方便排查问题
            logger.error("[系统异常]{}",e);
            return ResultUtil.ERROR(-1,"未知错误");
        }
    }
}
