package com.ecom.service;

import java.util.List;
import java.util.Map;

import com.ecom.dao.ProductDao;
import com.ecom.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	@Override
	public Map<Object, Object> loadMainProductDetail(int mainProductId) throws Exception {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.loadMainProductDetail(mainProductId);
	}
	@Override
	public List<Map<Object, Object>> loadAddonProductDetails(int parentProductId) throws Exception {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.loadAddonProductDetails(parentProductId);
	}
	
	@Override
	public List<Map<Object, Object>> getParentProductForAddToCart(String id) throws Exception {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.getParentProductForAddToCart(id);
	}
	
	@Override
	public List<Map<Object, Object>> getAddonRelationForAddToCart(String id) throws Exception {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.getAddonRelationForAddToCart(id);
	}
}
