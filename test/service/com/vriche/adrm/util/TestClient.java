package com.vriche.adrm.util;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import junit.framework.TestCase;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

//import javax.xml.rpc.ServiceException;
//import org.apache.axis.client.Call;
//import org.apache.axis.client.Service; 

public class TestClient extends TestCase {
    private static EndpointReference targetEPR = new EndpointReference("http://121.28.83.134:8081/adrm/services/Version");
    public void testAdd() {
        try {
            OMElement payload = ClientUtil.getEchoOMElement();
            Options options = new Options();
           
            options.setTo(targetEPR);
//            options.setAction("urn:echo");
            options.setAction("getVersion");
            
            //Blocking invocation
            ServiceClient sender = new ServiceClient(); 
            sender.setOptions(options);
            OMElement result = sender.sendReceive(payload);

            System.out.println(result);
           
            System.out.println(options.getTo());

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }
    
    
    private static OMElement getPayload() {  
        OMFactory fac = OMAbstractFactory.getOMFactory();  
        OMNamespace omNs = fac.createOMNamespace(  
                "http://ws", "example1");  
        OMElement method = fac.createOMElement("showName", omNs);  
        OMElement value = fac.createOMElement("name", omNs);  
        value.addChild(fac.createOMText(value, "Rest"));  
        method.addChild(value);  
        return method;  
    }  
    
	 public static void main(String[] args) {

	 
//		 Options options = new Options();  
//	        options.setTo(targetEPR);  
//	         
//	        //客户端REST方式调用服务跟普通服务的区别，REST调用必须加上下面这个代码。  
//	        options.setProperty(Constants.Configuration.ENABLE_REST, Constants.VALUE_TRUE);  
//	        ServiceClient sender = new ServiceClient();  
//	        //axis2-1.5.4不需要下面这句代码，否则会报错  
//	        //sender.engageModule(new QName(Constants.MODULE_ADDRESSING));  
//	        sender.setOptions(options);  
//	        OMElement result = sender.sendReceive(getPayload());  
//	        try {  
//	            XMLStreamWriter writer = XMLOutputFactory.newInstance()  
//	                    .createXMLStreamWriter(System.out);  
//	            result.serialize(writer);  
//	            writer.flush();  
//	        } catch (XMLStreamException e) {  
//	            e.printStackTrace();  
//	        } catch (FactoryConfigurationError e) {  
//	            e.printStackTrace();  
//	        }  
	    } 
}
