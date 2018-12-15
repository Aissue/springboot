package com.aissue.springboot.exception;

/**
 *
 * @author YS
 * @date 2017/3/8
 */
public class BizException extends RuntimeException {
    /**
     * 异常码
     */
    private String code;
    public BizException(String code,String msg){
        super(msg);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        StringBuffer sb =  new StringBuffer();
        sb.append(getClass().getName()).append("：");
        String message = getLocalizedMessage();
        if(code !=null) sb.append(code).append("\t");
        if(message !=null) sb.append(message);
        return sb.toString();
    }
}
