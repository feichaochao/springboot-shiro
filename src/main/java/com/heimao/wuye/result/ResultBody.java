package com.heimao.wuye.result;

import java.io.Serializable;

/**
 * 返回体
 *
 * @author wuyeheimao
 */

public class ResultBody<T> implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T result;

    public ResultBody(ErrorInfoInterface errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public ResultBody(T result) {
        this.code = GlobalInfoEnum.SUCCESS.getCode();
        this.message = GlobalInfoEnum.SUCCESS.getMessage();
        this.result = result;
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    
   
}
