package com.hcc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebStartCloseListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Web服务启动。。。");
		
		ServletContext application = sce.getServletContext();
		String paramValue = application.getInitParameter("此Web项目的意义");
		System.out.println("此Web项目的意义"+"："+paramValue);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Web服务关闭。。。");
	}

}
