package com.ecom.service;

import java.util.List;
import java.util.Map;

public interface CartService {

	Map<String,Object> getCartDetails(List<Object> cartDetails)throws Exception;
	Long saveParentProductToCart(List<Map<Object,Object>> parentProduct, Map<String,String> cityRelation, String session, String deliverydate, String shipping, Double shippingPrice) throws Exception;
	void saveAddonListToCart(List<Map<Object,Object>> parentProduct, Map<String,String> cityRelation, String session, String deliverydate, 
			String shipping, Long subOrderId)throws Exception;
	Long getSubOrder(String session) throws Exception;
	int getOrder(String session) throws Exception;
	String updateCartOrder(int orderid,String sessionid)throws Exception;
	String updateShipping(String rec_name,String rec_add,String rec_pin,String rec_mob,Long subOrderId)throws Exception;
	boolean updateCartPrice(long cartid,int quantity,double price)throws Exception;
}
