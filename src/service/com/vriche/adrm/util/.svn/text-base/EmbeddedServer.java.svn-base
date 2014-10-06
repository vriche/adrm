package com.vriche.adrm.util;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.server.http.XFireHttpServer;
import org.codehaus.xfire.service.Service;
//import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.service.invoker.BeanInvoker;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.vriche.adrm.service.AdrmWebService;
import com.vriche.adrm.service.impl.AdrmWebServiceImpl;

public class EmbeddedServer {
	
	  XFireHttpServer server;

	public boolean start() {
		ObjectServiceFactory serviceFactory = new ObjectServiceFactory();
//		Service service = serviceFactory.create(AdrmWebService.class);
//		Service service = serviceFactory.create(AdrmWebService.class);
//		service.setInvoker(new BeanInvoker(new AdrmWebServiceImpl()));
//		//注册服务
//		XFire xfire = XFireFactory.newInstance().getXFire();
//		xfire.getServiceRegistry().register(service);
//		//启动服务器
//		server = new XFireHttpServer();
//		server.setPort(8191);
		try {
			server.start();
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	
	public boolean stop() {

		//启动服务器
		try {
			server.stop();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		EmbeddedServer server = new EmbeddedServer();
		server.start();
	}
	
}
