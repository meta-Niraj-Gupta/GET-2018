package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/signUp")
public class SignUpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		HttpServletResponse res = (HttpServletResponse) response;
		PrintWriter out = res.getWriter();
		
		HttpServletRequest req = (HttpServletRequest) request;
		String firstname = req.getParameter("firstName");
		String lastname = req.getParameter("lastName");
		final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z]$");
		Matcher matchFirstname = VALID_NAME_PATTERN.matcher(firstname);
		Matcher matchLastName = VALID_NAME_PATTERN.matcher("lastname");
		if(matchFirstname.find() && matchLastName.find()){
			chain.doFilter(request, response);
		}else if(matchFirstname.find()){
			out.println("Invalid Last Name");
		}else{
			out.println("Invalid First Name");
		}
	}

}
