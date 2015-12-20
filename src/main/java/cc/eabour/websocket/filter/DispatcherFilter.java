package cc.eabour.websocket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns={"/*"})
public class DispatcherFilter implements Filter {

	private Logger logger = Logger.getLogger(DispatcherFilter.class);
	
	public void destroy() {
		// Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		logger.info("Request URL: " + request.getRequestURL());
		chain.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// Auto-generated method stub

	}

}
