package com.ym.blog.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/26 21:27
 * @Desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean success;

    private Integer code;

    private String msg;

    private Object data;

    public static Result success(){
        return new Result(true,200,"success",null);
    }

    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    public static Result fail(Integer code,String msg){
        return new Result(false,code,msg,null);
    }
}
