package com.ecom.service;

import java.util.List;
import java.util.Map;

import com.ecom.dao.CategoryDao;
import com.ecom.dao.CategoryDaoImpl;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Map<String, Object>> getListOfProductsFromCategory(int categoryId) throws Exception {
		CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.getListOfProductsFromCategory(categoryId);
	}
	@Override
	public String getCategoryName(int categoryId) throws Exception {
		CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.getCategoryName(categoryId);
	}
}
