package com.vriche.adrm.util;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
public class ClientUtil {
    public static OMElement getEchoOMElement() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "[url]http://example1.org/example1[/url]", "example1");
        OMElement method = fac.createOMElement("echo", omNs);
        OMElement value = fac.createOMElement("Text", omNs);
        value.addChild(fac.createOMText(value, "Axis2 Echo String "));
        method.addChild(value);
        return method;
    }
    public static OMElement getPingOMElement() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "[url]http://example1.org/example1[/url]", "example1");
        OMElement method = fac.createOMElement("ping", omNs);
        OMElement value = fac.createOMElement("Text", omNs);
        value.addChild(fac.createOMText(value, "Axis2 Ping String "));
        method.addChild(value);
        return method;
    }
    
    
}
