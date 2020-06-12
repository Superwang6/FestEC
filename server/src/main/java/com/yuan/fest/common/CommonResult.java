package com.yuan.fest.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 通用返回对象
 * @param <T>
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private String code;
    private String message;
    private T data;

    protected CommonResult(String code,T data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }
    /**
     * 成功返回结果
     * @param data 获取数据信息
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功返回结果
     * @param data 获取数据信息
     * @param message   提示信息
     */
    public static <T> CommonResult<T> success(T data,String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.ERROR.getCode(),ResultCode.ERROR.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param resultCode    失败错误原因
     */
    public static <T> CommonResult<T> failed(ResultCode resultCode) {
        return new CommonResult<T>(resultCode.getCode(),resultCode.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param resultCode    失败错误原因
     * @param message   失败提示信息
     */
    public static <T> CommonResult<T> failed(ResultCode resultCode,String message) {
        return new CommonResult<T>(resultCode.getCode(),message,null);
    }
}
