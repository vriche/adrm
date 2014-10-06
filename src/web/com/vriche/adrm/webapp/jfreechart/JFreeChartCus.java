package com.vriche.adrm.webapp.jfreechart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.service.JFreeChartService;


public class JFreeChartCus extends HttpServlet{
	
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 75061840102565826L;
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException {
		JFreeChartService jFreeChart = (JFreeChartService)getBean("jFreeChartService");
		
//		System.out.println("jFreeChart = " + jFreeChart);
		
	}
	

	public Object getBean(String name) {
    	ApplicationContext ctx = 
        	WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }	
}









