package io.adhikari.employeeManager.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestCallInterceptor extends OncePerRequestFilter  {

	
	  @Override protected void doFilterInternal(HttpServletRequest request,
	  HttpServletResponse response, FilterChain filterChain) throws
	  ServletException, IOException { System.out.println("Request URI is: " +
	  request.getRequestURI()); filterChain.doFilter(request, response);
	  System.out.println("Response Status Code is: " + response.getStatus()); }
	 
}
