package com.qf.minchang.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.minchang.dao.AddressDao;
import com.qf.minchang.dao.AddressDaoImpl;
import com.qf.minchang.dao.GoodsDao;
import com.qf.minchang.dao.GoodsDaoImpl;
import com.qf.minchang.entity.CartItem;
import com.qf.minchang.entity.Goods;
import com.qf.minchang.entity.User;

/**
 * 购物车管理(暂时)
 * @author MinChang
 * */
@SuppressWarnings("all")
@WebServlet(urlPatterns="/cart2")
public class CartServlet extends HttpServlet {
	
	//购物车
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String action=req.getParameter("action");
			System.out.println("cart:"+action);//判断action值

			if(action.equals("addToCart")) {//判断action是否登录addToCart
				
				int id=Integer.parseInt(req.getParameter("id"));
				GoodsDao goods=new GoodsDaoImpl();
				Goods goods1=goods.FindGoodsById(id);//获取id对象信息
				//获取Session值对象
				HttpSession session=req.getSession();
				//取出map对象
				Object cart = session.getAttribute("cart");
				//根据判断session值是否为空,来确定是否是第一次添加购物车
				if(cart!=null) {//重复加入购物车
					//取出购物车对象
					Map map=(Map) cart;
					if(map.containsKey(id)) {//如果购物车存在
						//
						CartItem item=(CartItem) map.get(id);
						//向item添加 数量加一
						item.setNum(item.getNum()+1);
						map.put(id, item);
					}else {//如果购物车不存在
						CartItem cartItem=new CartItem(1,goods1);
						map.put(goods1.getId(), cartItem);
					}
					session.setAttribute("cart", map);					
					
				}else {//第一次加入购物车
					//创建购物车的map对象
					HashMap mycart =new HashMap();
					//创建购物车项
					CartItem cartItem = new CartItem(1,goods1);
					//map对象放入购物车项
					mycart.put(goods1.getId(), cartItem);
					//将map对象放入session域中
					session.setAttribute("cart", mycart);
					
				}

				resp.sendRedirect("cart.jsp");

				//返回页面
			}else if(action.equals("return")){
					req.getRequestDispatcher("goodsList.jsp").forward(req, resp);
			}else if(action.equals("delete")) {
				int id=Integer.parseInt(req.getParameter("id"));
				GoodsDao goods=new GoodsDaoImpl();
				Goods goods1=goods.FindGoodsById(id);//获取id对象信息
				//获取Session值对象
				HttpSession session=req.getSession();
				
				//取出map对象
				Object cart = session.getAttribute("cart");
				Map map=(Map) cart;
				map.remove(id);
/*				CartItem item=(CartItem) map.get(id);
				//向item添加 数量减一
				item.setNum(item.getNum()-1);
				map.put(id, item);*/
				session.setAttribute("cart", map);
				resp.sendRedirect("cart.jsp");
			} 

			
		}
}
