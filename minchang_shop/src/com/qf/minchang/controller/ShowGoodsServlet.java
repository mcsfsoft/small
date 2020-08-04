package com.qf.minchang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.minchang.dao.ShowGoodsDao;
import com.qf.minchang.dao.ShowGoodsDaoImpl;
import com.qf.minchang.entity.Goods;
import com.qf.minchang.entity.GoodsType;
import com.qf.minchang.entity.ShowGoods;


@WebServlet(urlPatterns="/shows")

public class ShowGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String action = req.getParameter("action");
			System.out.println("action_type:"+action);
			if(action!=null) {
				if(action.equals("type")) {
					
					ShowGoodsDao dao=new ShowGoodsDaoImpl();
					List<ShowGoods> list=dao.findThingAll();
					req.setAttribute("act", list);
					req.getRequestDispatcher("admin/showGoodsType.jsp").forward(req, resp);
				}else if(action.equals("showGoods")) {
					String name = req.getParameter("name");
					String pudbate = req.getParameter("pubdate");
					ShowGoodsDao dao=new ShowGoodsDaoImpl();
					List<GoodsType> list=dao.findShowGoods(name,pudbate);
					req.setAttribute("lists", list);
					req.getRequestDispatcher("admin/showGoods.jsp").forward(req, resp);
				}
				else if(action.equals("addGoodsType")) {
					ShowGoodsDao dao=new ShowGoodsDaoImpl();
					List<GoodsType> gd=dao.finType();
					System.out.println(gd.toString());
					req.setAttribute("select", gd);
					req.getRequestDispatcher("admin/addGoodsType.jsp").forward(req, resp);
				}
			}
	}
}
