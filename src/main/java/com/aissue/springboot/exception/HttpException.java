package com.aissue.springboot.exception;

/**
 * Created by 子华 on 2017/8/14.
 */
public class HttpException extends BizException {

    public HttpException(String code, String msg) {
        super(code, msg);
    }
}
