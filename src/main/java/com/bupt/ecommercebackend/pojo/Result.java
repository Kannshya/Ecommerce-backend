package com.bupt.ecommercebackend.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL) // 排除值为 null 的字段
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 无参构造器和全参构造器
    public Result() {}
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法，返回成功的结果
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    // 静态方法，返回成功的结果，不带数据
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    // 静态方法，返回失败的结果
    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
