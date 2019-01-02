package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 子华
 * @date 2018/6/28
 */
public class WsdlOperationInfo {

    private String operationName;

    private String requestXml;

    private String responseXml;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getRequestXml() {
        return requestXml;
    }

    public void setRequestXml(String requestXml) {
        this.requestXml = requestXml;
    }

    public String getResponseXml() {
        return responseXml;
    }

    public void setResponseXml(String responseXml) {
        this.responseXml = responseXml;
    }

    /**
     *  把requestXml信息转换成Map参数
     * @return
     */
    public Map<String,Object> requestXmlToMap(){
        return xml2Map(requestXml);
    }

    /**
     *  把responseXml信息转换成Map参数
     * @return
     */
    public Map<String,Object> responseXmlToMap(){
        return xml2Map(responseXml);
    }

    /**
     * 转换操作
     * @param xml
     * @return
     */
    private Map<String,Object> xml2Map(String xml){
        // todo 解析xml 把参数提取出来
        Map<String,Object> map = new HashMap();
        return null;
    }
}
