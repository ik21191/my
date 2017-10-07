package com.ecom.service;

public interface RemoveCartItemService {
	boolean removeParentProductFromCart(long parentProductId, String sessionId) throws Exception;
	boolean removeAddonProductFromCart(long addonProductId,String sessionId)throws Exception;
}
