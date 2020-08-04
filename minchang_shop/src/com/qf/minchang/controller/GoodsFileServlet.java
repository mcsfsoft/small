package com.qf.minchang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.qf.minchang.dao.GoodsDao;
import com.qf.minchang.dao.GoodsDaoImpl;


@WebServlet(urlPatterns="/addGoods")
@MultipartConfig   //�ϴ��ļ��������
public class GoodsFileServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String typeid = req.getParameter("typeid");
		String pubdate = req.getParameter("pubdate");
		String price = req.getParameter("price");
		String star = req.getParameter("star");
		String intro=req.getParameter("intro");

		Part part = req.getPart("picture");
		String headerName = part.getHeader("context-disposition");//ͷ����
		GoodsDao dao=new GoodsDaoImpl();
		int a=dao.updateGoodsFile(name,typeid,pubdate,price,star,intro);
		if(a!=0) {
			System.out.println("�ϴ��ɹ�");
		}else {
			System.out.println("�ϴ�ʧ��");
		}
		req.getRequestDispatcher("admin/addGoods.jsp").forward(req, resp);
		
	}
}
