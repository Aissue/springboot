package com.aissue.springboot.exception;

/**
 * Created by 子华 on 2017/8/8.
 */
public class ProviderException extends BizException {
    public ProviderException(String code,String msg){
        super(code,msg);
    }
}
