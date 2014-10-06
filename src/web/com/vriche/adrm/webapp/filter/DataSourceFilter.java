package com.vriche.adrm.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.vriche.adrm.util.SpObserver;

public class DataSourceFilter implements Filter {

	public DataSourceFilter() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String dataSource = httpRequest.getParameter("dataSource");
		SpObserver.putSp(dataSource);
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
