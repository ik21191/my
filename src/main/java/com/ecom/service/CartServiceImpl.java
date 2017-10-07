package com.ecom.service;

import java.util.List;
import java.util.Map;

import com.ecom.dao.CartDao;
import com.ecom.dao.CartDaoImpl;

public class CartServiceImpl implements CartService {

	@Override
	public Map<String, Object> getCartDetails(List<Object> cartDetails) throws Exception {
		CartDao cartDao = new CartDaoImpl();
		return cartDao.getCartDetails(cartDetails);
	}
	
	@Override
	public Long saveParentProductToCart(List<Map<Object, Object>> parentProduct, Map<String, String> cityRelation, String session, String deliverydate, String shipping, Double shippingPrice) throws Exception{
		CartDao cartDao = new CartDaoImpl();
		return cartDao.saveParentProductToCart(parentProduct, cityRelation, session, deliverydate, shipping, shippingPrice);
	}
	
	@Override
	public void saveAddonListToCart(List<Map<Object, Object>> parentProduct, Map<String, String> cityRelation, String session,
			String deliverydate, String shipping, Long subOrderId) throws Exception {
		CartDao cartDao = new CartDaoImpl();
		cartDao.saveAddonListToCart(parentProduct, cityRelation, session, deliverydate, shipping, subOrderId);
	}
	
	@Override
	public Long getSubOrder(String session) throws Exception {
		CartDao cartDao = new CartDaoImpl();
		return cartDao.getSubOrder(session);
	}
	
	@Override
	public int getOrder(String session) throws Exception {
		CartDao cartDao = new CartDaoImpl();
		return cartDao.getOrder(session);
	}
	
	@Override
	public synchronized String updateCartOrder(int orderid, String sessionid) throws Exception {
		CartDao cartDao = new CartDaoImpl();
		return cartDao.updateCartOrder(orderid, sessionid);
	}
	
	@Override
	public String updateShipping(String rec_name, String rec_add,
			String rec_pin, String rec_mob, Long subOrderId) throws Exception {
		CartDao cartDao = new CartDaoImpl();
		return cartDao.updateShipping(rec_name, rec_add, rec_pin, rec_mob, subOrderId);
	}
	
	@Override
	public boolean updateCartPrice(long cartid, int quantity, double price) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
