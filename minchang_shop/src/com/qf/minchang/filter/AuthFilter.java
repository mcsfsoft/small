package com.qf.minchang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.minchang.entity.User;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
			HttpSession session=req.getSession();
			Object attr1=session.getAttribute("userInfo");
			User attr=(User)attr1;
			//���ڼӶ���ֵ
			if(attr==null) {
				//û�е�¼�������
				resp.sendRedirect("login.jsp");
			}else if("admin".equals(attr.getUsername())){
				chain.doFilter(req, resp);
			}else {
				resp.sendRedirect("../index.jsp");
			}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
			
	}

}
