package com.zking.ssm.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置tomcat允许跨域访问
 * 
 * @author Administrator
 *
 */
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		// Access-Control-Allow-Origin就是我们需要设置的域名
		// Access-Control-Allow-Headers跨域允许包含的头。
		// Access-Control-Allow-Methods是允许的请求方式
		httpResponse.addHeader("Access-Control-Allow-Origin", "*");// *,任何域名
		httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}