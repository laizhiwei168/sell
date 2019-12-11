package com.cimc.enums;

import lombok.Getter;

/**
 * 返回结果枚举类
 */
@Getter
public enum ResultEnum implements CodeEnum{
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),
    UPLOADING_NULL(102,"上传文件不为空"),
    UPLOADING_FAULT(103,"上传文件失败"),
    UPLOADING_ERROR(104,"上传文件错误"),
    NOTSELLER_ERROR(105,"用户不存在"),
    PARAMETER_ERROR(106,"参数不为空"),
    ;


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    /*public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }*/

}
