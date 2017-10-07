package com.ecom.dao;

import java.util.List;
import java.util.Map;

public interface ProductDao {
	Map<Object, Object> loadMainProductDetail(int mainProductId) throws Exception;
	List<Map<Object, Object>> loadAddonProductDetails(int sourceProductId)throws Exception;
	List<Map<Object,Object>> getParentProductForAddToCart(String id) throws Exception;
	List<Map<Object,Object>> getAddonRelationForAddToCart(String id) throws Exception;
}
