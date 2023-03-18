package com.gnanayakkara.SpringTest.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/*
 * 10 Oct 2022
 */

@Component
public class RequestFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 String url = ((HttpServletRequest)request).getRequestURL().toString();
		 String queryString = ((HttpServletRequest)request).getQueryString();
		 System.out.println(url + "?" + queryString);
		chain.doFilter(request, response);
	}
}
