package com.gfl.utils.commons;


public enum ConstantUtils {

    REDIS_AREALIST("areaList","redis中的放的地区的key");
    ;

    private ConstantUtils(){

    }

    ConstantUtils(String key,String value) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
