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
		System.out.println("LoginFilter��������ʼִ�С�����������");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setContentType("text/plain;charset=UTF-8");
		httpResponse.setCharacterEncoding("UTF-8");
		
		System.out.println("���ط����IPΪ��"+httpRequest.getLocalAddr());
		System.out.println("������ʵ�IPΪ��"+httpRequest.getRemoteAddr());
		System.out.println("�����URIΪ��"+httpRequest.getRequestURI());
		System.out.println("�����·��Ϊ��"+httpRequest.getServletPath());
		
		HttpSession session = httpRequest.getSession(false);
		if(session == null) {
			String userName = httpRequest.getParameter("name");
			String password = httpRequest.getParameter("password");		
			if("hcc".equals(userName) && "123456".equals(password)) {
				// url?name=hcc&password=123456
				session = httpRequest.getSession(true);
				session.setMaxInactiveInterval(60);
				PrintWriter out = httpResponse.getWriter();
				out.write("����¼�ɹ���");
				out.flush();
			}else {
				PrintWriter out = httpResponse.getWriter();
				out.write("����δ��¼���¼ʧ�ܣ�����д�˺������¼��");
				out.flush();
			}			
		}else {
			//�ѵ�¼,�������������
			chain.doFilter(httpRequest, httpResponse);
		}
	
		System.out.println("LoginFilter������ִ�н���������������");
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

}
