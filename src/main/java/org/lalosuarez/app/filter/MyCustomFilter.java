package org.lalosuarez.app.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCustomFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	      @SuppressWarnings("unused")
		String testParam = filterConfig.getInitParameter("test-param"); 
	      //System.out.println("** My custom filter init param: " + testParam + " **"); 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		  
		  String ipAddress = request.getRemoteAddr();
		
		  //System.out.println("** My custom filter executed **");
		  System.out.println("IP "+ ipAddress + ", Time "
		                                   + new Date().toString());
		
		  // Pass request back down the filter chain
		  chain.doFilter(request,response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
