package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/webapi/*")
public class AuthorizationFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(req.getHeader("AuthKey") != null){
			chain.doFilter(request, response);
		}else{
			res.sendError(401);
		}
		chain.doFilter(request, response);
	}

public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
}

}
