package com.ecom.service;

import java.util.List;
import java.util.Map;

public interface CategoryService {
	List<Map<String, Object>> getListOfProductsFromCategory(int categoryId) throws Exception;
	String getCategoryName(int categoryId) throws Exception;
}
