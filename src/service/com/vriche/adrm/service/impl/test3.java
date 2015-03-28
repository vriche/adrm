package com.vriche.adrm.service.impl;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.vriche.adrm.model.Income;

public class test3 {

	public test3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1111111");
		
		try {
			RPCServiceClient serviceClient = new  RPCServiceClient();
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference("http://168.168.168.2:8080/adrm/services/IncomeManagerImpl");
			options.setTo(targetEPR);
//			QName opAddEntry = new QName("http://vriche.com/ADP/service/IncomeManagerImpl/0.1", "getIncomes");
			QName opAddEntry = new QName("http://impl.service.adrm.vriche.com", "getIncomes");
			
		
			Object[] opAddEntryArgs = new Object[] {new Income()};
//			serviceClient.invokeRobust(opAddEntry, opAddEntryArgs);
//			List ls = serviceClient.invokeRobust(opAddEntry, opAddEntryArgs);
			  System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs).toString());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
