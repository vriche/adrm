package com.vriche.adrm.util;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class GetWSByAxis2 {
	 private static String EndPointUrl;   
     private static String QUrl="http://ws.apache.org/axis2"; 
     private QName opAddEntry;    
     public String WSUrl; 
     
     public RPCServiceClient setOption() throws AxisFault   
     {   
         RPCServiceClient serviceClient = new RPCServiceClient();   
         Options options = serviceClient.getOptions();   
         EndpointReference targetEPR = new EndpointReference(WSUrl);   
         options.setTo(targetEPR);   
         return serviceClient;   
     }   
        
     public QName getQname(String Option){   
            
         return new QName(QUrl,Option);   
     }   
     
     
     //����String   
     public String get(String Option) throws AxisFault   
     {   
         RPCServiceClient serviceClient =this.setOption();    
       
         opAddEntry =this.getQname(Option);   
        
        String str = (String) serviceClient.invokeBlocking(opAddEntry,    
                         new Object[]{}, new Class[]{String.class })[0];   
        return str;   
    } 
     
     
     //����String   
     public String getStr(String Option,String why) throws AxisFault   
     {   
         RPCServiceClient serviceClient =this.setOption();    
       
         opAddEntry =this.getQname(Option);   
        
        String str = (String) serviceClient.invokeBlocking(opAddEntry,    
                         new Object[]{why}, new Class[]{String.class })[0];   
        return str;   
    }   
// ����һάString����   
     public String[] getArray(String Option) throws AxisFault   
     {   
         RPCServiceClient serviceClient =this.setOption();    
       
         opAddEntry =this.getQname(Option);   
        
        String[] strArray = (String[]) serviceClient.invokeBlocking(opAddEntry,    
                         new Object[]{}, new Class[]{String[].class })[0];   
        return strArray;   
    }   
     //��WebService�з���һ�������ʵ��   
    public Object getObject(String Option,Object o) throws AxisFault   
    {    
       RPCServiceClient serviceClient =this.setOption();    
        QName qname=this.getQname(Option);   
        Object object = serviceClient.invokeBlocking(qname, new Object[]{},new Class[]{o.getClass()})[0];   
        return object;   
    }    
}
