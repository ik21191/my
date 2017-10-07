package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.ecom.db.helper.ConnectionFactory;
import com.ecom.utils.DbUtil;

public class RemoveCartItemDaoImpl implements RemoveCartItemDao {
	private Logger log = Logger.getLogger(RemoveCartItemDaoImpl.class);
	@Override
	public boolean removeParentProductFromCart(long parentProductId, String sessionId) throws Exception {
		boolean result = false;
		Connection con = ConnectionFactory.getConnection();
		String query = "DELETE FROM ORDER_CART_ENTRY WHERE SUB_ORDER_ID=? AND SESSIONID=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setLong(1, parentProductId);
		stm.setString(2, sessionId);
		int i = stm.executeUpdate();
		if (i != 0)
			result = true;
		log.info("Deletion result is : " + result);
		DbUtil.close(con);
		DbUtil.close(stm);
		return result;
	}

	@Override
	public boolean removeAddonProductFromCart(long addonProductId, String sessionId) throws Exception {
		boolean result = false;
		Connection con = ConnectionFactory.getConnection();
		String query = "DELETE FROM ORDER_CART_ENTRY WHERE ID=? AND SESSIONID=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setLong(1, addonProductId);
		stm.setString(2, sessionId);
		int i = stm.executeUpdate();
		if (i != 0)
			result = true;
		log.info("Deletion result is : " + result);
		DbUtil.close(con);
		DbUtil.close(stm);
		return result;
	}

}
