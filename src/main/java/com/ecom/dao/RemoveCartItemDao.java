package com.ecom.dao;

public interface RemoveCartItemDao {
	boolean removeParentProductFromCart(long parentProductId, String sessionId) throws Exception;
	boolean removeAddonProductFromCart(long addonProductId,String sessionId)throws Exception;
}
