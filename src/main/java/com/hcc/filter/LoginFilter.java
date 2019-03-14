package com.hcc.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter过滤器开始执行。。。。。。");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setContentType("text/plain;charset=UTF-8");
		httpResponse.setCharacterEncoding("UTF-8");
		
		System.out.println("本地服务的IP为："+httpRequest.getLocalAddr());
		System.out.println("请求访问的IP为："+httpRequest.getRemoteAddr());
		System.out.println("请求的URI为："+httpRequest.getRequestURI());
		System.out.println("请求的路径为："+httpRequest.getServletPath());
		
		HttpSession session = httpRequest.getSession(false);
		if(session == null) {
			String userName = httpRequest.getParameter("name");
			String password = httpRequest.getParameter("password");		
			if("hcc".equals(userName) && "123456".equals(password)) {
				// url?name=hcc&password=123456
				session = httpRequest.getSession(true);
				session.setMaxInactiveInterval(60);
				PrintWriter out = httpResponse.getWriter();
				out.write("您登录成功！");
				out.flush();
			}else {
				PrintWriter out = httpResponse.getWriter();
				out.write("您尚未登录或登录失败，请填写账号密码登录！");
				out.flush();
			}			
		}else {
			//已登录,则继续后续处理
			chain.doFilter(httpRequest, httpResponse);
		}
	
		System.out.println("LoginFilter过滤器执行结束。。。。。。");
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

}
