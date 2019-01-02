package com.example.demo.entity;

import java.util.List;

/**
 *
 * @author 子华
 * @date 2018/6/28
 */
public class WsdlInterfaceInfo {

    private String url;

    private String soapVersion;

    private String interfaceName;

    private List<WsdlOperationInfo> wsdlOperationInfos;


    public String getSoapVersion() {
        return soapVersion;
    }

    public void setSoapVersion(String soapVersion) {
        this.soapVersion = soapVersion;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<WsdlOperationInfo> getWsdlOperationInfos() {
        return wsdlOperationInfos;
    }

    public void setWsdlOperationInfos(List<WsdlOperationInfo> wsdlOperationInfos) {
        this.wsdlOperationInfos = wsdlOperationInfos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
