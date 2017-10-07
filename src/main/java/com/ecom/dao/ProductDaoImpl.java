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

public class ProductDaoImpl implements ProductDao {

	@Override
	public Map<Object, Object> loadMainProductDetail(int id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String query = "select p.PRODUCT_ID,p.ITEM_NAME,p.sku,p.shortdescription,p.longdescription,p.sell_price,p.purchase_price,p.meta_title,p.meta_keyword,"
				+ " p.meta_description,p.title,image.largeimage,group_concat(distinct(concat(concat(city.id,':'),city.name))) as CityName,image.smallimage "
				+ " from BASE_PRODUCT p,BASE_PRODUCTIMAGE image,shippingmode sm,PRODUCTSHIPPING ps,BASE_SHIPPINGGROUP sg,BASE_CITYGROUP_RELATION rel,"
				+ "BASE_CITY city where image.productid=p.product_id and p.product_id=ps.productid and ps.shippingid=sm.id and sg.shippingmodeid=sm.id and "
				+ "sg.id=rel.citygroupid and rel.cityid=city.id and p.product_id=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, id);
		ResultSet rset = stm.executeQuery();
		Map<Object, Object> mainProductDetailMap = new HashMap<Object, Object>();
		while (rset.next()) {
			mainProductDetailMap.put("productId", rset.getLong(1));
			mainProductDetailMap.put("productName", rset.getString(2));
			mainProductDetailMap.put("productSku", rset.getString(3));
			mainProductDetailMap.put("shortDescription", rset.getString(4));
			mainProductDetailMap.put("longDescription", rset.getString(5));
			mainProductDetailMap.put("productPrice", rset.getDouble(6));
			mainProductDetailMap.put("productPurchasePrice", rset.getDouble(7));
			mainProductDetailMap.put("meta_title", rset.getString(8));
			mainProductDetailMap.put("meta_keyword", rset.getString(9));
			mainProductDetailMap.put("meta_description", rset.getString(10));
			mainProductDetailMap.put("productTitle", rset.getString(11));
			mainProductDetailMap.put("productLargeImage", "productImages/" + rset.getString(12));
			mainProductDetailMap.put("cityList", rset.getString(13));
			mainProductDetailMap.put("productSmallImage", "productImages/" + rset.getString(14));
		}
		DbUtil.close(con);
		DbUtil.close(stm);
		DbUtil.close(rset);
		return mainProductDetailMap;
	}

	@Override
	public List<Map<Object, Object>> loadAddonProductDetails(int parentProductId) throws Exception {
		List<Map<Object, Object>> addonList = new ArrayList<Map<Object, Object>>();
		Connection con = ConnectionFactory.getConnection();
		String query = "select addons.addonid,p2.item_name,p2.sell_price,image.smallimage "
				+ " from BASE_PRODUCTADDON_RELATION addons,BASE_PRODUCT p1,BASE_PRODUCT p2,BASE_PRODUCTIMAGE image "
				+ " where addons.productid=p1.product_id and addons.addonid=p2.product_id and image.productid=p2.product_id "
				+ " and p1.product_id=? order by addons.sequence";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, parentProductId);
		ResultSet rset = stm.executeQuery();
		while (rset.next()) {
			Map<Object, Object> addonProduct = new HashMap<Object, Object>();
			addonProduct.put("addonId", rset.getLong(1));
			addonProduct.put("addonName", rset.getString(2));
			addonProduct.put("addonPrice", rset.getDouble(3));
			addonProduct.put("addonSmallImage", "productImages/" + rset.getString(4));
			addonList.add(addonProduct);
		}
		DbUtil.close(con);
		DbUtil.close(stm);
		DbUtil.close(rset);
		return addonList;
	}
	
	@Override
	public List<Map<Object, Object>> getParentProductForAddToCart(String id) throws Exception {
		List<Map<Object, Object>> parentProduct = new ArrayList<Map<Object, Object>>();
		Connection con = ConnectionFactory.getConnection();
		String query = "select p1.product_id as productId,p1.item_name as productName,p1.sell_price productUnitPrice,image.smallimage "
				+ "as productSmallImage from BASE_PRODUCT p1,BASE_PRODUCTIMAGE image "
				+ " where image.productid=p1.product_id and p1.adl_string_1='Yes' and p1.product_id in ("
				+ id + ")";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		ResultSet rset = stm.executeQuery();
		while (rset.next()) {
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("productType", "parentProduct");
			map.put("productId", rset.getLong("productId"));
			map.put("productUnitPrice", rset.getDouble("productUnitPrice"));
			map.put("productQty", 1 + "");
			map.put("productName", rset.getString("productName"));
			map.put("productSmallImage", "productImages/" + rset.getString(4));
			parentProduct.add(map);
		}
		return parentProduct;
	}
	
	@Override
	public List<Map<Object, Object>> getAddonRelationForAddToCart(String id) throws Exception {
		List<Map<Object, Object>> addonList = new ArrayList<Map<Object, Object>>();
		Connection con = ConnectionFactory.getConnection();
		String query = "select p1.product_id as productId,p1.item_name as productName,p1.sell_price productUnitPrice,image.smallimage "
				+ "as productSmallImage from BASE_PRODUCT p1,BASE_PRODUCTIMAGE image "
				+ " where image.productid=p1.product_id and p1.adl_string_1='No' and p1.product_id in ("
				+ id + ")";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		ResultSet rset = stm.executeQuery();
		while (rset.next()) {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("productType", "addon");
			map.put("productId", rset.getLong("productId"));
			map.put("productUnitPrice", rset.getDouble("productUnitPrice"));
			map.put("productQty", 1);
			map.put("productName", rset.getString("productName"));
			map.put("productSmallImage", "productImages/" + rset.getString(4));
			addonList.add(map);
		}
		return addonList;
	}
}
