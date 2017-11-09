package com.heimao.wuye.result;

/**
 * 统一错误码异常
 *
 * @author wuyeheimao
 */
public class GlobalErrorInfoException extends RuntimeException {

    
	private static final long serialVersionUID = 1L;
	private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}
