package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import web.utility.DateUtility;

import com.ecom.db.helper.ConnectionFactory;

public class CartDaoImpl implements CartDao {

	private Logger log = Logger.getLogger(CartDaoImpl.class);
	
	@Override
	public Map<String, Object> getCartDetails(List<Object> cartDetails) throws Exception {
		Map<String, Object> cartMap = new HashMap<String, Object>();
		List<Object> cartdDetailsUpdated = new ArrayList<Object>();
		Map<Object, Object> cartUpdated = null;
		List<Map<Object, Object>> parentProduct = null;
		List<Map<Object, Object>> addonList = null;
		Iterator<Object> itr = cartDetails.iterator();
		Set<Long> subOrderSet = new HashSet<Long>();
		while (itr.hasNext()) {
			Map<Object, Object> cart = (Map<Object, Object>) itr.next();
			subOrderSet.add((Long) cart.get("subOrderId"));
			log.info("######################");
		}
		log.info(subOrderSet.size());
		double cartValue = 0.0;

		for (Long subOrderId : subOrderSet) {
			boolean flag = false;
			parentProduct = new ArrayList<Map<Object, Object>>();
			addonList = new ArrayList<Map<Object, Object>>();
			try {
				Connection con = ConnectionFactory.getConnection();
				String query = "SELECT CART.ID AS ID,CART.SESSIONID AS SESSIONID,CART.PRODUCT_TYPE AS PRODUCT_TYPE,CART.PRODUCT_ID AS PRODUCT_ID,"
						+ "CART.PRODUCT_UNIT_PRICE AS PRODUCT_UNIT_PRICE,CART.PRODUCT_QTY AS PRODUCT_QTY,"
						+ "CART.PRODUCT_SUB_TOTAL AS PRODUCT_SUB_TOTAL,CART.PRODUCT_NAME AS PRODUCT_NAME,CART.ORDER_ID AS ORDER_ID,"
						+ "CART.SUB_ORDER_ID AS SUB_ORDER_ID,CART.STATUS AS STATUS,CART.ORDER_BY AS ORDER_BY,"
						+ "CART.CREATED_DATE AS CREATED_DATE,CART.CITY_ID AS CITY_ID,CART.CITY_NAME AS CITY_NAME,CART.STATE_ID AS "
						+ "STATE_ID,CART.STATE_NAME AS STATE_NAME,CART.COUNTRY_ID AS COUNTRY_ID,"
						+ "CART.COUNTRY_NAME AS COUNTRY_NAME,CART.SHIP_DATE AS SHIP_DATE,CART.SHIPPING AS SHIPPING,"
						+ "CART.SHIPPING_PRICE AS SHIPPING_PRICE,CART.SHIP_RECIPIENT AS SHIP_RECIPIENT,"
						+ "CART.SHIPP_ADDRESS AS SHIPP_ADDRESS,CART.SHIPP_PINCODE AS SHIPP_PINCODE,CART.SHIPP_MOBILE AS SHIPP_MOBILE,"
						+ "IMAGE.SMALLIMAGE AS SMALLIMAGE,IMAGE.LARGEIMAGE AS LARGEIMAGE "
						+ "FROM ORDER_CART_ENTRY CART,BASE_PRODUCTIMAGE IMAGE,BASE_PRODUCT PRODUCT WHERE "
						+ "CART.PRODUCT_ID=PRODUCT.PRODUCT_ID AND PRODUCT.PRODUCT_ID=IMAGE.PRODUCTID AND SUB_ORDER_ID=?";
				PreparedStatement stm = con.prepareStatement(query.toLowerCase());
				stm.setLong(1, subOrderId);
				ResultSet rset = stm.executeQuery();
				while (rset.next()) {
					flag = true;
					if (rset.getString("PRODUCT_TYPE").equalsIgnoreCase("parentProduct")) {
						Map<Object, Object> map1 = new HashMap<Object, Object>();
						map1.put("cartid", rset.getString("ID"));
						map1.put("productType", rset.getString("PRODUCT_TYPE"));
						map1.put("productUnitPrice", rset.getDouble("PRODUCT_UNIT_PRICE"));
						map1.put("productSubTotal", rset.getDouble("PRODUCT_SUB_TOTAL"));
						map1.put("productQty", rset.getString("PRODUCT_QTY"));
						cartValue = cartValue + rset.getDouble("PRODUCT_SUB_TOTAL");
						map1.put("productId", rset.getLong("PRODUCT_ID"));
						map1.put("productName", rset.getString("PRODUCT_NAME"));
						map1.put("cityId", rset.getInt("CITY_ID"));
						map1.put("cityName", rset.getString("CITY_NAME"));
						map1.put("stateId", rset.getInt("STATE_ID"));
						map1.put("stateName", rset.getString("STATE_NAME"));
						map1.put("countryId", rset.getInt("COUNTRY_ID"));
						map1.put("countryName", rset.getString("COUNTRY_NAME"));
						map1.put("deliverydate", rset.getString("SHIP_DATE"));
						// map1.put("shippingId",
						// (Integer)shippingMode.get("shippingId"));
						map1.put("shippingTitle", rset.getString("SHIPPING"));
						map1.put("shippingWp", rset.getString("SHIPPING_PRICE"));
						map1.put("SHIP_RECIPIENT", rset.getString("SHIP_RECIPIENT"));
						map1.put("SHIPP_ADDRESS", rset.getString("SHIPP_ADDRESS"));
						map1.put("SHIPP_PINCODE", rset.getString("SHIPP_PINCODE"));
						map1.put("SHIPP_MOBILE", rset.getString("SHIPP_MOBILE"));
						cartValue = cartValue + rset.getDouble("SHIPPING_PRICE");
						map1.put("productLargeImage", "productImages/" + rset.getString("LARGEIMAGE"));
						map1.put("productSmallImage", "productImages/" + rset.getString("SMALLIMAGE"));
						parentProduct.add(map1);
					} else {
						Map<Object, Object> map2 = new HashMap<Object, Object>();
						map2.put("cartid", rset.getString("ID"));
						map2.put("productType", rset.getString("PRODUCT_TYPE"));
						map2.put("productUnitPrice", rset.getDouble("PRODUCT_UNIT_PRICE"));
						map2.put("productSubTotal",	rset.getDouble("PRODUCT_SUB_TOTAL"));
						map2.put("productQty", rset.getString("PRODUCT_QTY"));
						cartValue = cartValue + rset.getDouble("PRODUCT_SUB_TOTAL");
						map2.put("productId", rset.getLong("PRODUCT_ID"));
						map2.put("productName", rset.getString("PRODUCT_NAME"));
						map2.put("cityId", rset.getInt("CITY_ID"));
						map2.put("cityName", rset.getString("CITY_NAME"));
						map2.put("stateId", rset.getInt("STATE_ID"));
						map2.put("stateName", rset.getString("STATE_NAME"));
						map2.put("countryId", rset.getInt("COUNTRY_ID"));
						map2.put("countryName", rset.getString("COUNTRY_NAME"));
						map2.put("deliverydate", rset.getString("SHIP_DATE"));
						map2.put("shipping", rset.getString("SHIPPING"));
						map2.put("productLargeImage", "productImages/" + rset.getString("LARGEIMAGE"));
						map2.put("productSmallImage", "productImages/" + rset.getString("SMALLIMAGE"));
						addonList.add(map2);
					}
				}
				cartUpdated = new HashMap<Object, Object>();
				cartUpdated.put("parentProduct", parentProduct);
				cartUpdated.put("addonList", addonList);
				cartUpdated.put("subOrderId", subOrderId);
			} catch (Exception e) {
				log.error(e);
			}
			if (flag) {
				cartdDetailsUpdated.add(cartUpdated);
				cartMap.put("cartDetails", cartdDetailsUpdated);
				cartMap.put("cartValue", cartValue);
			}
		}
		return cartMap;
	}
	
	@Override
	public Long saveParentProductToCart(List<Map<Object, Object>> parentProduct, Map<String, String> cityRelation, String session,
			String deliverydate, String shipping, Double shippingPrice) throws Exception {
		List<Map<Object,Object>> updatedList=new ArrayList<Map<Object,Object>>();
    	Long subOrderId=getSubOrder(session);
    	Iterator<Map<Object,Object>> itr=parentProduct.iterator();
    	while(itr.hasNext())
    	try
    	{
    		Map<Object,Object> product=itr.next();
    		Connection con=ConnectionFactory.getConnection();
    		String query="INSERT INTO ORDER_CART_ENTRY(SESSIONID,PRODUCT_TYPE,PRODUCT_ID,PRODUCT_UNIT_PRICE,PRODUCT_QTY," +
    		"PRODUCT_SUB_TOTAL,PRODUCT_NAME,ORDER_ID,SUB_ORDER_ID,STATUS,ORDER_BY,CREATED_DATE,CITY_ID,CITY_NAME," +
    		"STATE_ID,STATE_NAME,COUNTRY_ID,COUNTRY_NAME,SHIP_DATE,SHIPPING,SHIPPING_PRICE) VALUES(?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement stm=con.prepareStatement
    		(query.toLowerCase(),Statement.RETURN_GENERATED_KEYS);
    		String productType=(String)product.get("productType");
    		Double productUnitPrice=(Double)product.get("productUnitPrice");
    		Double productSubTotal=(Double)product.get("productUnitPrice");
    		int order_By;
    		if(productType.equalsIgnoreCase("parentProduct"))
    			order_By=1;
    		else
    			order_By=2;
    				stm.setString(1,session);
    				stm.setString(2,productType);
    				stm.setLong(3,(Long)product.get("productId"));
    				stm.setDouble(4,productUnitPrice);
    				stm.setInt(5,1);
    				log.info("Product price "+(Double)product.get("productUnitPrice"));
    				stm.setDouble(6,productSubTotal);
    				stm.setString(7,(String)product.get("productName"));
    				stm.setLong(8,subOrderId);
    				stm.setString(9,"Unconfirmed");
    				stm.setInt(10,order_By);
    				stm.setString(11, DateUtility.getCurrentDate());
    				stm.setInt(12, Integer.parseInt(cityRelation.get("cityId")));
    				stm.setString(13, cityRelation.get("cityName"));
    				stm.setInt(14, Integer.parseInt(cityRelation.get("stateId")));
    				stm.setString(15, cityRelation.get("stateName"));
    				stm.setInt(16, Integer.parseInt(cityRelation.get("countryId")));
    				stm.setString(17, cityRelation.get("countryName"));
    				stm.setString(18, deliverydate);
    				stm.setString(19, shipping);
    				stm.setDouble(20, shippingPrice);
    				stm.executeUpdate();
    				ResultSet rset=stm.getGeneratedKeys();
    				while(rset.next())
    				product.put("cartid",rset.getLong(1));
    				product.put("subOrderId",subOrderId);
    				updatedList.add(product);
    		}
    		catch(Exception e)
            {
                log.info(e);
            }
    		parentProduct=updatedList;
    		return subOrderId;
		
	}
	
	@Override
	public void saveAddonListToCart(List<Map<Object, Object>> parentProduct, Map<String, String> cityRelation, String session,
			String deliverydate, String shipping, Long subOrderId) throws Exception {
		List<Map<Object,Object>> updatedList=new ArrayList<Map<Object,Object>>();
    	Iterator<Map<Object,Object>> itr=parentProduct.iterator();
    	while(itr.hasNext())
    	try
    	{
    		Map<Object,Object> product=itr.next();
    		Connection con=ConnectionFactory.getConnection();
    		String query="INSERT INTO ORDER_CART_ENTRY(SESSIONID,PRODUCT_TYPE,PRODUCT_ID,PRODUCT_UNIT_PRICE,PRODUCT_QTY," +
    		"PRODUCT_SUB_TOTAL,PRODUCT_NAME,ORDER_ID,SUB_ORDER_ID,STATUS,ORDER_BY,CREATED_DATE,CITY_ID,CITY_NAME," +
    		"STATE_ID,STATE_NAME,COUNTRY_ID,COUNTRY_NAME,SHIP_DATE,SHIPPING) VALUES(?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement stm=con.prepareStatement
    		(query.toLowerCase(),Statement.RETURN_GENERATED_KEYS);
    		String productType=(String)product.get("productType");
    		Double productUnitPrice=(Double)product.get("productUnitPrice");
    		Double productSubTotal=(Double)product.get("productUnitPrice");
    		int order_By;
    		if(productType.equalsIgnoreCase("parentProduct"))
    			order_By=1;
    		else
    			order_By=2;
    				stm.setString(1,session);
    				stm.setString(2,productType);
    				stm.setLong(3,(Long)product.get("productId"));
    				stm.setDouble(4,productUnitPrice);
    				stm.setInt(5,1);
    				log.info("Product price "+(Double)product.get("productUnitPrice"));
    				stm.setDouble(6,productSubTotal);
    				stm.setString(7,(String)product.get("productName"));
    				stm.setLong(8,subOrderId);
    				stm.setString(9,"Unconfirmed");
    				stm.setInt(10,order_By);
    				stm.setString(11, DateUtility.getCurrentDate());
    				stm.setInt(12, Integer.parseInt(cityRelation.get("cityId")));
    				stm.setString(13, cityRelation.get("cityName"));
    				stm.setInt(14, Integer.parseInt(cityRelation.get("stateId")));
    				stm.setString(15, cityRelation.get("stateName"));
    				stm.setInt(16, Integer.parseInt(cityRelation.get("countryId")));
    				stm.setString(17, cityRelation.get("countryName"));
    				stm.setString(18, deliverydate);
    				stm.setString(19, shipping);
    				stm.executeUpdate();
    				ResultSet rset=stm.getGeneratedKeys();
    				while(rset.next())
    				product.put("cartid",rset.getLong(1));
    				product.put("subOrderId", subOrderId);
    				updatedList.add(product);
    		}
    		catch(Exception e)
            {
                log.error(e);
            }
    		parentProduct=updatedList;
		
	}
	
	@Override
	public Long getSubOrder(String session) throws Exception {
		Long i = 0l;
		Connection con = ConnectionFactory.getConnection();
		String query = "INSERT INTO BASE_SUB_ORDER(SESSIONID,CREATED_TIME) values(?,?)";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase(), Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, session);
		stm.setString(2, DateUtility.getCurrentDate());
		stm.executeUpdate();
		ResultSet rset = stm.getGeneratedKeys();
		while (rset.next()) {
			i = rset.getLong(1);
		}
		return i;
	}
	
	@Override
	public int getOrder(String session) throws Exception {
		int i = 0;
		Connection con = ConnectionFactory.getConnection();
		String query = "INSERT INTO BASE_ORDER(sessionid,STATUS) values(?,?)";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase(), Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, session);
		stm.setString(2, "UnConfirmed");
		stm.executeUpdate();
		ResultSet rset = stm.getGeneratedKeys();
		while (rset.next()) {
			i = rset.getInt(1);
		}
		return i;
	}
	
	@Override
	public synchronized String updateCartOrder(int orderid, String sessionid) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE ORDER_CART_ENTRY SET ORDER_ID=? WHERE SESSIONID=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, orderid);
		stm.setString(2, sessionid);
		int i = stm.executeUpdate();
		log.info("Update result is : " + i);
		return "success";
	}
	
	@Override
	public synchronized String updateShipping(String rec_name, String rec_add,
			String rec_pin, String rec_mob, Long subOrderId) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE ORDER_CART_ENTRY SET SHIP_RECIPIENT=?,SHIPP_ADDRESS=?,SHIPP_PINCODE=?,"
				+ "SHIPP_MOBILE=? WHERE SUB_ORDER_ID=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setString(1, rec_name);
		stm.setString(2, rec_add);
		stm.setString(3, rec_pin);
		stm.setString(4, rec_mob);
		stm.setLong(5, subOrderId);
		int i = stm.executeUpdate();
		log.info("Update result is : " + i);
		return "success";
	}
	
	@Override
	public synchronized boolean updateCartPrice(long cartid, int quantity, double price) throws Exception {
		boolean result = false;
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE ORDER_CART_ENTRY SET PRODUCT_QTY=?,PRODUCT_SUB_TOTAL=? WHERE ID=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		log.info(cartid + "  " + quantity + "  " + price);
		stm.setInt(1, quantity);
		stm.setDouble(2, (quantity * price));
		stm.setLong(3, cartid);
		int i = stm.executeUpdate();
		if (i != 0) {
			result = true;
		}
		log.info("Update result is : " + i);
		return result;
	}
}
