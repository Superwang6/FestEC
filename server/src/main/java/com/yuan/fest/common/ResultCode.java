package com.yuan.fest.common;

public enum ResultCode {
    EXCEPTION("-1","异常错误")
    ,SUCCESS("0","操作成功")
    ,ERROR("1","操作失败")
    ,PARAM_ERROR("2","参数错误")
    ,UNJURISDICTION("3","无权登录")
    ,ERROR_LOGINFORUSERNAMEPASSWORK("4","用户名密码错误")
    ,NOT_LOGIN("5","未登录")
    ;
    private String code;
    private String message;

    private ResultCode(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
