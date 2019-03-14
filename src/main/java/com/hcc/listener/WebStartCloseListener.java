package com.hcc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebStartCloseListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Web��������������");
		
		ServletContext application = sce.getServletContext();
		String paramValue = application.getInitParameter("��Web��Ŀ������");
		System.out.println("��Web��Ŀ������"+"��"+paramValue);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Web����رա�����");
	}

}
