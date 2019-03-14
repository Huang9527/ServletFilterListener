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
		System.out.println("���յ�����IP��"+ip+"������"+uri);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
		String ip = httpRequest.getRemoteAddr();
		String uri = httpRequest.getRequestURI();
		System.out.println("����IP��"+ip+"������"+uri+"�������\n");
	}

}
