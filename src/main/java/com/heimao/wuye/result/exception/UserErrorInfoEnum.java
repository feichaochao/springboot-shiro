package com.heimao.wuye.result.exception;

import com.heimao.wuye.result.ErrorInfoInterface;

/**
 * 业务错误码 
 *
 *@author wuyeheimao
 */
public enum UserErrorInfoEnum implements ErrorInfoInterface {
    PARAMS_NO_COMPLETE("000001","params no complete"),
    USER_EXIT("000002","USER exit");

    private String code;

    private String message;

    UserErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
