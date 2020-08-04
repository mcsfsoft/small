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
 * ���ﳵ����(��ʱ)
 * @author MinChang
 * */
@SuppressWarnings("all")
@WebServlet(urlPatterns="/cart2")
public class CartServlet extends HttpServlet {
	
	//���ﳵ
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String action=req.getParameter("action");
			System.out.println("cart:"+action);//�ж�actionֵ

			if(action.equals("addToCart")) {//�ж�action�Ƿ��¼addToCart
				
				int id=Integer.parseInt(req.getParameter("id"));
				GoodsDao goods=new GoodsDaoImpl();
				Goods goods1=goods.FindGoodsById(id);//��ȡid������Ϣ
				//��ȡSessionֵ����
				HttpSession session=req.getSession();
				//ȡ��map����
				Object cart = session.getAttribute("cart");
				//�����ж�sessionֵ�Ƿ�Ϊ��,��ȷ���Ƿ��ǵ�һ����ӹ��ﳵ
				if(cart!=null) {//�ظ����빺�ﳵ
					//ȡ�����ﳵ����
					Map map=(Map) cart;
					if(map.containsKey(id)) {//������ﳵ����
						//
						CartItem item=(CartItem) map.get(id);
						//��item��� ������һ
						item.setNum(item.getNum()+1);
						map.put(id, item);
					}else {//������ﳵ������
						CartItem cartItem=new CartItem(1,goods1);
						map.put(goods1.getId(), cartItem);
					}
					session.setAttribute("cart", map);					
					
				}else {//��һ�μ��빺�ﳵ
					//�������ﳵ��map����
					HashMap mycart =new HashMap();
					//�������ﳵ��
					CartItem cartItem = new CartItem(1,goods1);
					//map������빺�ﳵ��
					mycart.put(goods1.getId(), cartItem);
					//��map�������session����
					session.setAttribute("cart", mycart);
					
				}

				resp.sendRedirect("cart.jsp");

				//����ҳ��
			}else if(action.equals("return")){
					req.getRequestDispatcher("goodsList.jsp").forward(req, resp);
			}else if(action.equals("delete")) {
				int id=Integer.parseInt(req.getParameter("id"));
				GoodsDao goods=new GoodsDaoImpl();
				Goods goods1=goods.FindGoodsById(id);//��ȡid������Ϣ
				//��ȡSessionֵ����
				HttpSession session=req.getSession();
				
				//ȡ��map����
				Object cart = session.getAttribute("cart");
				Map map=(Map) cart;
				map.remove(id);
/*				CartItem item=(CartItem) map.get(id);
				//��item��� ������һ
				item.setNum(item.getNum()-1);
				map.put(id, item);*/
				session.setAttribute("cart", map);
				resp.sendRedirect("cart.jsp");
			} 

			
		}
}
