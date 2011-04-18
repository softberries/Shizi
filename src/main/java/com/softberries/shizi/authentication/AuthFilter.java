package com.softberries.shizi.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns="/app/*")
public class AuthFilter implements javax.servlet.Filter{

	private static final Logger LOG = Logger.getLogger(AuthFilter.class);
	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain fc) throws IOException, ServletException {
		LOG.debug("filtering request");
		fc.doFilter(arg0, arg1);
	}

	@Override
	public void destroy() {
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
