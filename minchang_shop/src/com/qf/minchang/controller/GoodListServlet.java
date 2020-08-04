package com.qf.minchang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.minchang.dao.GoodsDao;
import com.qf.minchang.dao.GoodsDaoImpl;
import com.qf.minchang.entity.Goods;


@SuppressWarnings("all")
@WebServlet(urlPatterns="/goodListServlet")
public class GoodListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String action=req.getParameter("action");
		System.out.println("action:"+action);
		
		
		if(action==null||action.equals("goodsList")) {
			System.out.println("goodList:我进来了");
			String name=req.getParameter("name");
			name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
			GoodsDao goods=new GoodsDaoImpl();
			List<Goods> list=goods.findThingByName(name);
			req.setAttribute("goods", list);
			req.setAttribute("name", name);
			req.getRequestDispatcher("goodsList.jsp").forward(req, resp);
			System.out.println("goodList:我退出了");
			
			
		}else if(action.equals("findById")) {
			int id=Integer.parseInt(req.getParameter("id"));
			GoodsDao goods=new GoodsDaoImpl();
			Goods goods1=goods.FindGoodsById(id);
			req.setAttribute("goods", goods1);
			req.getRequestDispatcher("goodsDetail.jsp").forward(req, resp);
		}
	}
}
