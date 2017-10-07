package com.ecom.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
	Map<Object, Object> loadMainProductDetail(int mainProductId) throws Exception;
	List<Map<Object, Object>> loadAddonProductDetails(int parentProductId)throws Exception;
	List<Map<Object,Object>> getParentProductForAddToCart(String id) throws Exception;
	List<Map<Object,Object>> getAddonRelationForAddToCart(String id) throws Exception;
}
