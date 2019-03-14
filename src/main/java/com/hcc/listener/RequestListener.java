package com.hcc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
		String ip = httpRequest.getRemoteAddr();
		String uri = httpRequest.getRequestURI();
		System.out.println("接收到来自IP："+ip+"的请求："+uri);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
		String ip = httpRequest.getRemoteAddr();
		String uri = httpRequest.getRequestURI();
		System.out.println("来自IP："+ip+"的请求："+uri+"处理结束\n");
	}

}
