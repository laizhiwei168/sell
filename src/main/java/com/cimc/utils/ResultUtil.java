package com.cimc.utils;

import com.cimc.entity.Result;

public class ResultUtil {
    public static Result SUCCESS(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result SUCCESS(){
        return SUCCESS(null);
    }

    public static Result ERROR(Integer code, String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
