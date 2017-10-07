package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecom.db.helper.ConnectionFactory;
import com.ecom.utils.DbUtil;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Map<String, Object>> getListOfProductsFromCategory(
			int categoryId) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT p.PRODUCT_ID,p.item_name,p.sku ,p.sell_price ,p.purchase_price,image.smallimage from "
				+ "BASE_PRODUCT p,BASE_PRODUCTCATEGORY c,BASE_PRODUCTIMAGE image WHERE p.PRODUCT_ID=c.PRODUCTID AND "
				+ " image.productid=p.PRODUCT_ID AND c.CATEGORYID=? AND c.STATUS='Yes'";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, categoryId);
		ResultSet rset = stm.executeQuery();
		while (rset.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("productId", rset.getInt(1));
			map.put("productName", rset.getString(2));
			map.put("productSku", rset.getString(3));
			map.put("productPrice", rset.getDouble(4));
			map.put("productPurchasePrice", rset.getDouble(5));
			map.put("productURL", (rset.getString(2).replaceAll(" ", "-") + "-"
					+ rset.getInt(1) + "-p.htm").toLowerCase());
			map.put("productSmallImage", "productImages/" + rset.getString(6));
			list.add(map);
		}
		DbUtil.close(con);
		DbUtil.close(stm);
		DbUtil.close(rset);
		return list;
	}
	
	@Override
	public String getCategoryName(int categoryId) throws Exception {
		String categoryName = "";
		String query = "select title from BASE_CATEGORY WHERE ID=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, categoryId);
		ResultSet rset = stm.executeQuery();
		while (rset.next()) {
			categoryName = rset.getString(1);
		}
		DbUtil.close(con);
		DbUtil.close(stm);
		DbUtil.close(rset);
		return categoryName;
	}
}
