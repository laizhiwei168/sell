package com.cimc.exception;

import com.cimc.enums.ResultEnum;

/**
 * 自定义全局异常类
 * 扩展exception中无法扩展的参数
 */
public class ArticleException extends RuntimeException {
    private Integer code;

    public ArticleException(ResultEnum R){
        super(R.getMsg());
        this.code=R.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
