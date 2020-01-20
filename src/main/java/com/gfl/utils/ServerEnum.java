package com.gfl.utils;

public enum ServerEnum {

     SUCCESS(200,"成功")
    ,ERROR(500,"失败")
    ;
    private ServerEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
