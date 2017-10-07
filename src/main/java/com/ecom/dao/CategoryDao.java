package com.ecom.dao;

import java.util.List;
import java.util.Map;

public interface CategoryDao {
	List<Map<String, Object>> getListOfProductsFromCategory(int categoryId) throws Exception;
	String getCategoryName(int categoryId) throws Exception;
}
