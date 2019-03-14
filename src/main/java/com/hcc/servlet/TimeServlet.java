package com.hcc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class TimeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5368281289429787057L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
		//req.setCharacterEncoding("UTF-8");//������������Ľ����ַ���
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String time = sdf.format(now);
		System.out.println("���ڵ�ʱ���ǣ�"+time);
		JSONObject json = new JSONObject();
		json.put("���ڵ�ʱ����", time);
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(json.toString());
		out.flush();
		
	}
	
}
